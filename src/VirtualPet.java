package Menu;

import java.io.*;
import java.util.*;
import java.text.*;

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
		 String fileName = new String();
		    
		 fileName = player.getPlayerName() + "_" + player.getPet().getName() + ".txt";
		 File newFile = new File (fileName);
		 PrintWriter file = new PrintWriter(newFile);
		 
		 file.println(player.getPlayerName()); // line 1
		 file.println(player.getPet().getName()); // line 2
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 file.println(dateFormat.format(date)); // line 3
		 //print semua state
		 file.println(player.getCoins()); // line 4
		 file.println(player.getToy().getLevel()); // line 5
		 file.println(player.getSoap().getLevel()); // line 6
		 file.println(player.getFood().getLevel()); // line 7
		 file.println(player.getFood().getQuantity()); // line 8
		 file.println(player.getPet().getType()); //line 9
		 file.println(player.getPet().getHunger()); //line 10
		 file.println(player.getPet().getHappiness()); //line 11
		 file.println(player.getPet().getHealth()); //line 12
		 file.println(player.getPet().getHygiene()); //line 13
		 file.println(player.getPet().getState()); //line 14		 
		 file.close();
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public static void main(String[] args) {
		VirtualPet pet = new VirtualPet();
		try {
			pet.loadGame("C:\\Users\\User\\workspace1\\VirtualPet\\Candy_Lala.txt");
			System.out.println(pet.getPlayer().getPlayerName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
	}
}