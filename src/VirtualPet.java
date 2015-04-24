package VirtualPet;
import java.io.*;
import java.util.*;
import java.text.*;

public class VirtualPet {
	private Player player;
	private MenuView view;
	
	public VirtualPet(){
		player = new Player();
		view = new MenuView();
	}
	
	public void newGame(){
		Scanner scan = new Scanner(System.in);
		String playerName = scan.nextLine();
		player.setPlayerName(playerName);
		String animalName = scan.nextLine();
		String animalType = scan.nextLine();
		player.adoptPet(animalName, animalType);
	}
	
	public void loadGame(String fileName){
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String playerName = in.nextLine();
		String animalName = in.nextLine();
		
		
		
		
		String date = in.nextLine();
		Date saveDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date);
		Date currentDate = new Date();
		long difference = currentDate.getTime() - saveDate.getTime();
		long diffHours = difference / (60 * 60 * 1000);
		//baca status lainnya
		//Kurangin status per jam
		
		
		player.loadPlayer(playerName,animalName);
		player.getPet().loadAnimal();
		
		
	}
	
	public void saveGame(){
		 String fileName = new String();
		    
		 fileName = player.getPlayerName() + "_" + player.getPet().getName() + ".txt";//new SimpleDateFormat("yyyyMMdd-hhmmss'.txt'").format(new Date());   
		 File newFile = new File (fileName);
		 PrintWriter file = new PrintWriter(newFile);
		 
		 file.println(player.getPlayerName());
		 file.println(player.getPet().getName());
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 file.println(dateFormat.format(date));
		 //print semua state
		 file.close();
		
	}
	
	public void help(){
		//TO-DO
	}
	
	public void exitGame(){
		// TO-DO ask to save game
	}
	public void notifyObserver(){
		
	}
	public void registerObserver(){
		
	}
	public void unregisterObserver(){
		
	}
	
}
