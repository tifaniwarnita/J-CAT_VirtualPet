
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class TestingNewView {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        JLayeredPane lpane = new JLayeredPane();
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(800,480));        
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 800, 480);
        
        Player player = new Player("Tifani");
        player.getPet().loadAnimal("Quinsy", "Cat", 60, 60, 60, 60, 1);
        
        AnimalView catObserver = new AnimalView();
        player.getPet().registerObserver(catObserver);
        System.out.println("STATUS PET: " + player.getPet().getState());
        
        StatusView statusObserver = new StatusView();
        player.getPet().registerObserver(statusObserver);
        System.out.println("STATUS PET: " + player.getPet().getState());
        
        GameView game = new GameView();
        player.registerObserver(game);
        
        System.out.println("STATUS PET: " + player.getPet().getState());
        game.setAnimalView(catObserver);
        System.out.println("STATUS PET: " + player.getPet().getState());
        
        game.setBounds(0, 0, 800, 480);
        game.setOpaque(true);
        catObserver.setBounds(0, 0, 800, 480);
        statusObserver.setBounds(0, 0, 800, 480);
        
        lpane.add(game, new Integer(0),0);
        lpane.add(catObserver, new Integer(1), 0);
        lpane.add(statusObserver, new Integer(2), 0);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Animal cat = new Animal("Bruno", "Cat", 60, 60, 60, 60, 60);
        //cat.registerObserver(catObserver);
        /*System.out.println(catObserver.getDefaultImage());
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setSize(new Dimension(800,480));        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread th = new Thread(game);
        th.start();
        /*GameView game = new GameView();
        game.setView(catObserver);
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setSize(new Dimension(800,480));        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread th = new Thread(game);
        th.start();*/
    }
}
