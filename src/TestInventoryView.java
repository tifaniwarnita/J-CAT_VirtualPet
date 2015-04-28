
import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS X202E
 */
public class TestInventoryView {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        Player p = new Player("Nilta");
        p.adoptPet("Bruno","Cat");
        p.setCoins(500);
        InventoryPanel inventory = new InventoryPanel();
        p.registerObserver(inventory);
        inventory.update("OPENINV");
        JFrame frame = new JFrame();
        frame.add(inventory);
        frame.setSize(new Dimension(800,480));        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
