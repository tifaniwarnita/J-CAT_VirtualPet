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
    JButton newgamebutton;
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
        setLayout(null);
        newgamebutton.setLocation(20,20);
        add(newgamebutton);
        // Just for refresh :) Not optional!
        setSize(800,480);
    }

    public static void main(String args[])
    {
        new MenuView();
    }
}