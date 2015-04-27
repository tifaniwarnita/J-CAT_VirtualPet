
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
        Animal cat = new Animal("Quinsy", "Cat", 10, 10, 10, 10, 10);
        AnimalView catObserver = new AnimalView();
        cat.registerObserver(catObserver);
        System.out.println(catObserver.getDefaultImage());
        GameView game = new GameView();
        game.setView(catObserver);
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setSize(new Dimension(800,480));        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread th = new Thread(game);
        th.start();
    }
}
