/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */

import com.sun.prism.j2d.J2DPipeline;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VirtualPetFrame extends JFrame {
    private Animal animal;
    private AnimalView animalView;
    private JButton bTest;
    private Thread animalThread;
    /**
     * Creates new form VirtualPetFrame
     */
    public VirtualPetFrame() {
        initUI();
    }
    
    private void initUI() {
        animal = new Animal("Bruno", "Cat");
        animalView = new CatView(animal.getMessage());
        animal.registerObserver(animalView);
        animalThread = new Thread (animalView);
       
        //add(animalView);
       
        /*bTest = (Button) new Button();
        bTest.setPreferredSize(new Dimension(100,100));
        animalView.add(bTest);*/
        bTest = new JButton();
        bTest.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        bTest.setText("TEST ACT");
        bTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTestMouseClicked(evt);
            }
        });
        createLayout(bTest, animalView);
         animalThread.start();
        /* JPanel jp = new JPanel();
        jp.add(bTest);
        jp.setPreferredSize(new Dimension(10,10));
        add(jp);
        add(animalView);*/
        
        
        
        setSize(800,480);
        setTitle("Virtual Pet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0], GroupLayout.DEFAULT_SIZE, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arg[1], GroupLayout.DEFAULT_SIZE, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );
    }
    
    private void bTestMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        this.animal.cleanBody(new Soap());
        System.out.println(this.animal.getMessage());
        System.out.println(this.animalView.getCondition());
    }              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirtualPetFrame().setVisible(true);
            }
        });
    }
          
}
