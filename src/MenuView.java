package View;

import Menu.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Menu.Player;

import java.awt.*;
import java.awt.event.*;
public class MenuView extends JFrame {
	private static VirtualPet pet;
    private static JButton newgamebutton;
    private static JButton loadgamebutton;
    private static JButton continuebutton;
    private static JButton savebutton;
    private static JButton exitbutton;
	private static JFrame frame = new JFrame();
	private static JFrame f;
	private static boolean gameexist;
    
    public MenuView()
    {
        frame.setTitle("Virtual Pet");
        frame.setPreferredSize(new java.awt.Dimension(800,600));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // Exit the application when user close frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        // Another way
        frame.setLayout(new BorderLayout());

        frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\background.png")));
        frame.setLayout(new FlowLayout());
        newgamebutton=new JButton(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\newgamebutton.png"));
        loadgamebutton=new JButton(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\loadgamebutton.png"));
        continuebutton=new JButton(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\continuebutton.png"));
        savebutton=new JButton(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\savebutton.png"));
        exitbutton=new JButton(new ImageIcon("C:\\Users\\User\\Documents\\GitHub\\J-CAT_VirtualPet\\design\\exitbutton.png"));

        frame.setLayout(null);
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

        //continuebutton
        continuebutton.setContentAreaFilled(false);
        continuebutton.setBorderPainted(false);
        
        continuebutton.setSize(149,51);
        continuebutton.setLocation(330, 260);
        
        //savebutton
        savebutton.setContentAreaFilled(false);
        savebutton.setBorderPainted(false);
        
        savebutton.setSize(149,51);
        savebutton.setLocation(330, 320);

        //exitbutton
        exitbutton.setContentAreaFilled(false);
        exitbutton.setBorderPainted(false);
        
        exitbutton.setSize(149,51);
        exitbutton.setLocation(330, 380);

        frame.add(newgamebutton);
        frame.add(loadgamebutton);
        frame.add(continuebutton);
        frame.add(savebutton);
        frame.add(exitbutton);
        
        // Just for refresh :) Not optional!
        frame.setSize(800,480);
        frame.setLocationRelativeTo(null);
    }
    
    public void prepareGameFrame() {
    	AnimalView catObserver = new AnimalView();
    	
    	System.out.println(pet.getPlayer().getPlayerName());
        
    	pet.getPlayer().getPet().registerObserver(catObserver);
        GameView game = new GameView(pet.getPlayer(), catObserver);

        pet.getPlayer().registerObserver(game);
        game.setAnimalView(catObserver);
        game.initialize();
        System.out.println(game.getPlayer().getPlayerName());
        System.out.println(catObserver.getDefaultImage());
      
        gameexist = true;
        
        f = new JFrame();
    	f.add(game);
        f.setSize(new Dimension(800,480));        
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread th = new Thread(game);
        th.start();
    	f.setVisible(true);
    	
    	 game.getbMainMenu().addActionListener(new ActionListener() {
          	 
             public void actionPerformed(ActionEvent e)
             {
                 //Execute when button is pressed
             	frame.setVisible(true);
             	f.setVisible(false);
             	
             }
         });
         
         game.getbInventory().addActionListener(new ActionListener() {
           	 
             public void actionPerformed(ActionEvent e)
             {
                 //Execute when button is pressed
             	
             	InventoryView inventory = new InventoryView();
             	JFrame fInventory = new JFrame();
                 fInventory.add(inventory);
                 pet.getPlayer().registerObserver(inventory);
                 inventory.update("OPENINV");
                 fInventory.setSize(new Dimension(800,480));        
                 fInventory.pack();
                 fInventory.setLocationRelativeTo(null);
                 fInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 f.setVisible(false);
                 fInventory.setVisible(true);
             }
         });
    	
    	
    }

    public static void main(String args[])
    {
        MenuView menu = new MenuView();
        gameexist = false;
        
        newgamebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	NewGameView newGame = new NewGameView();
            	JFrame newGameFrame = new JFrame();
            	newGameFrame.add(newGame);
            	newGameFrame.setSize(new Dimension(800,480));        
            	newGameFrame.pack();
            	newGameFrame.setLocationRelativeTo(null);
            	newGameFrame.setVisible(true);
            	newGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            	pet = new VirtualPet();
            	frame.setVisible(false);
            	
            	newGame.getStartButton().addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e){
	                	//Execute when button is pressed
	            		if (newGame.startButtonCheck()){
	            			pet.newGame(newGame.getPlayerName(), newGame.getPetName(), newGame.getPetType());
	            			menu.prepareGameFrame();
	                        newGameFrame.setVisible(false);
	            		}
                    }
                });

                continuebutton.addActionListener(new ActionListener() {
                	 
                    public void actionPerformed(ActionEvent e)
                    {
                    	//Execute when button is pressed
                    	f.setVisible(true);
                        frame.setVisible(false);
                    	
                    }
                });
            }
        });  

        loadgamebutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	pet = new VirtualPet();
                //Create a file chooser
            	JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text Files", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                   System.out.println("You choose to open this file: " +
                        chooser.getSelectedFile().getAbsolutePath());
                }
                
                try {
                	pet.loadGame(chooser.getSelectedFile().getAbsolutePath());
                	menu.prepareGameFrame();
                	frame.setVisible(false);
                	
                } catch (Exception exp) {
                	exp.printStackTrace();
                	System.out.println("Error");
                }                
                
                
                /*File file = new File(filename); //for ex foo.txt
                try {
                    FileReader reader = new FileReader(file);
                    char[] chars = new char[(int) file.length()];
                    reader.read(chars);
                    content = new String(chars);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        }); 
        
        continuebutton.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	
            	//Error Game_not_exist
            	if (!gameexist) {
                	JOptionPane.showMessageDialog(frame,
                    	    "No game was started!",
                    	    "Error",
                    	    JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        
        savebutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
              //Execute when button is pressed
              //Error Game_not_exist
            	if (!gameexist) {
                	JOptionPane.showMessageDialog(frame,
                    	    "No game was started!",
                    	    "Error",
                    	    JOptionPane.ERROR_MESSAGE);
            	} else {
            		try {
            			pet.saveGame();
            			JOptionPane.showMessageDialog(frame,
            				    "Save Succeed");
            		} catch (IOException e1) {
            			e1.printStackTrace();
            		}
            		
            	}
            }
        }); 

        exitbutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	int n = JOptionPane.showConfirmDialog(
            		    frame,
            		    "Are you sure want to exit?",
            		    "EXIT",
            		    JOptionPane.YES_NO_OPTION);
            	if (n==0) {
            		System.exit(0);
            	}
            	
                
            }
        }); 
        
       
    }
}