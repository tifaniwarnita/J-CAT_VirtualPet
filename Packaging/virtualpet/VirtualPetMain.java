/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author Tifani
 */
public class VirtualPetMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */
        JLayeredPane lpane = new JLayeredPane();
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(800,480));        
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 800, 480);
        
        AnimalSound checksound = new AnimalSound();
        Player player = new Player("Tifani");
        player.getPet().loadAnimal("Quinsy", "Cat", 60, 60, 60, 60, 1);
        
        AnimalView catObserver = new AnimalView();
        player.getPet().registerObserver(catObserver);
        player.getPet().registerObserver(checksound);
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
        
    }
    
}
