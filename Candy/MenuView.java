import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MenuView extends JFrame {
    private static JButton newgamebutton;
    private static JButton loadgamebutton;
    private static JButton helpbutton;
    private static JButton exitbutton;
    public MenuView()
    {

        this.setTitle("Virtual Pet");
        this.setPreferredSize(new java.awt.Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        // Exit the application when user close frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        
        // Another way
        setLayout(new BorderLayout());

        setContentPane(new JLabel(new ImageIcon("background.png")));
        setLayout(new FlowLayout());
        newgamebutton=new JButton(new ImageIcon("newgamebutton.png"));
        loadgamebutton=new JButton(new ImageIcon("loadgamebutton.png"));
        helpbutton=new JButton(new ImageIcon("helpbutton.png"));
        exitbutton=new JButton(new ImageIcon("exitbutton.png"));

        setLayout(null);
        //newgamebutton
        newgamebutton.setContentAreaFilled(false);
        newgamebutton.setBorderPainted(false);
        
        newgamebutton.setSize(149,51);
        newgamebutton.setLocation(330, 140);

        //loadgamebutton
        loadgamebutton.setContentAreaFilled(false);
        loadgamebutton.setBorderPainted(false);
        
        loadgamebutton.setSize(149,51);
        loadgamebutton.setLocation(330, 200);

        //helpbutton
        helpbutton.setContentAreaFilled(false);
        helpbutton.setBorderPainted(false);
        
        helpbutton.setSize(149,51);
        helpbutton.setLocation(330, 260);

        //exitbutton
        exitbutton.setContentAreaFilled(false);
        exitbutton.setBorderPainted(false);
        
        exitbutton.setSize(149,51);
        exitbutton.setLocation(330, 320);

        add(newgamebutton);
        add(loadgamebutton);
        add(helpbutton);
        add(exitbutton);
        
        // Just for refresh :) Not optional!
        setSize(800,480);
    }

    public static void main(String args[])
    {
        new MenuView();

        newgamebutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });  

        loadgamebutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                //Create a file chooser
                final JFileChooser fc = new JFileChooser();
                System.out.println("You clicked the button");
            }
        }); 

        helpbutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        }); 

        exitbutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.exit(0);
            }
        }); 
    }
}