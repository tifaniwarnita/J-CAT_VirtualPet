package virtualpet;

import java.io.*;
import java.util.*;
import java.text.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Nama File : VirtualPet.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public class VirtualPet {
	private Player player;
	
	public VirtualPet(){
		player = new Player();
	}
	
	public void newGame(String playerName, String petName, String animalType){
		player.setPlayerName(playerName);
		player.adoptPet(petName,animalType);
		player.getPet().setHappiness(100);
		player.getPet().setHealth(100);
		player.getPet().setHunger(100);
		player.getPet().setHygiene(100);
	}
	
	public void loadGame(String fileName) throws Exception {
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String playerName = in.nextLine(); //line1
		String animalName = in.nextLine(); //line2
		
				
		String date = in.nextLine(); //line3
		Date saveDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date);
		Date currentDate = new Date();
		long difference = currentDate.getTime() - saveDate.getTime();
		long diffHours = difference / (60 * 60 * 1000);
		
		//baca status lainnya
		int _coins = Integer.parseInt(in.nextLine()); // line 4
		int toylevel = Integer.parseInt(in.nextLine()); // line 5
		int soaplevel = Integer.parseInt(in.nextLine()); // line 6
		int foodlevel = Integer.parseInt(in.nextLine()); // line 7
		int foodqty = Integer.parseInt(in.nextLine()); // line 8
		String type = in.nextLine(); //line 9
		int hunger = Integer.parseInt(in.nextLine()); // line 10
		int happiness = Integer.parseInt(in.nextLine()); // line 11
		int health = Integer.parseInt(in.nextLine()); // line 12
		int hygiene = Integer.parseInt(in.nextLine()); // line 13
		int state = Integer.parseInt(in.nextLine()); // line 14
		
		if (state==0){ //kalau pet bangun
			health += diffHours;
			if (health > 100)
				health = 100;
		}
		else {
			health -= diffHours;
			if (health < 5)
				health = 5;
		}
		hunger -= diffHours;
		if (hunger < 5)
			hunger = 5;
		happiness -= diffHours;
		if (happiness < 5)
			happiness = 5;
		hygiene -= diffHours;
		if (hygiene < 5)
			hygiene = 5;
		
		in.close();
		player.loadPlayer(playerName, _coins, toylevel, soaplevel, foodlevel, foodqty);
		player.getPet().loadAnimal (animalName, type, hunger, happiness, health, hygiene, state);
	}
	
	public void saveGame() throws IOException {
		 JFileChooser chooser = new JFileChooser();
                 FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "J-CAT Files", "jcat");
                    chooser.setFileFilter(filter);
		    //chooser.setCurrentDirectory(new File("C:/Users/User/workspace1"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		    	try {
		    		try(FileWriter file = new FileWriter(chooser.getSelectedFile()+".jcat")) {
                                       
		    			file.write(player.getPlayerName()+"\n"); // line 1
		    			file.write(player.getPet().getName()+"\n"); // line 2
		    			 
		    			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    			Date date = new Date();
		    			file.write(dateFormat.format(date)+"\n"); // line 3
		    			//print semua state
		    			file.write(player.getCoins()+"\n"); // line 4
		    			file.write(player.getToy().getLevel()+"\n"); // line 5
		    			file.write(player.getSoap().getLevel()+"\n"); // line 6
		    			file.write(player.getFood().getLevel()+"\n"); // line 7
		    			file.write(player.getFood().getQuantity()+"\n"); // line 8
		    			file.write(player.getPet().getType()+"\n"); //line 9
		    			file.write(player.getPet().getHunger()+"\n"); //line 10
		    			file.write(player.getPet().getHappiness()+"\n"); //line 11
		    			file.write(player.getPet().getHealth()+"\n"); //line 12
		    			file.write(player.getPet().getHygiene()+"\n"); //line 13
		    			file.write(player.getPet().getState()+"\n"); //line 14		 
		    			file.close();
		    		}
	            	JOptionPane.showMessageDialog(null,"Save Succeed");
		        } catch (IOException e1) {
     			e1.printStackTrace();
	            	JOptionPane.showMessageDialog(null,"Save Canceled");
     		}	
     	}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}