
import java.awt.Dimension;
import javax.swing.JFrame;

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
        Player player = new Player("Tifani");
        player.getPet().loadAnimal("Bruno", "Cat", 60, 60, 60, 60, 60);
        AnimalView catObserver = new AnimalView();
        player.getPet().registerObserver(catObserver);
        GameView game = new GameView();
        player.registerObserver(game);
        game.setAnimalView(catObserver);
        game.initialize();
        System.out.println(game.getPlayer().getPlayerName());
        
        //Animal cat = new Animal("Bruno", "Cat", 60, 60, 60, 60, 60);
        //cat.registerObserver(catObserver);
        System.out.println(catObserver.getDefaultImage());
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
