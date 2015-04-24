/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author ASUS X202E
 */
public class Player {
    private int coins;
    private String playerName;
    private Animal pet;
    private ArrayList<Product> productCollection = new ArrayList<>();
    private Random rand = new Random();

    public Player(String name) {
        this.coins = 0;
        this.playerName = name;
        productCollection.add(new Toy());
        productCollection.add(new Soap());
        productCollection.add(new Food());
    }
    
    public void loadPlayer(int _coins, int toylevel, int soaplevel, int foodlevel, int foodqty) {
        setCoins(_coins);
        if (toylevel>1) getToy().changeLevel(toylevel);
        if (soaplevel>1) getSoap().changeLevel(soaplevel);
        if (foodlevel>1) getFood().changeLevel(foodlevel);
        if (foodqty>0) getFood().setQuantity(foodqty);
    }
    /**
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    void adoptPet (String _name, String _type) {
        setPet(new Animal(_name, _type));
    }
    
    void feedPet() {
        if (getFood().getQuantity()>=1) {
            getPet().eatFood(getFood());
            getFood().updateQuantity(-1);
            setCoins(getCoins()+rand.nextInt((int)(getFood().getCurrentPrice()*1.5))+1);
            //notify success
        }
        else {
            //notify fail
        }
    }
    
    void cleanPet() {
        getPet().cleanBody(getSoap());
       setCoins(getCoins()+rand.nextInt((int)(getSoap().getIndex()+0.1)*50)+1);
       //notify
    }
    
    void playPet() {
        getPet().playGame(getToy()); 
       setCoins(getCoins()+rand.nextInt((int)(getToy().getIndex()+0.1)*50)+1);
       //notify
    }
    
    
    public void upgradeProduct(int i) {
        if (coins>=productCollection.get(i).getUpgradePrice()) {
            coins-=productCollection.get(i).getUpgradePrice();
            productCollection.get(i).upgrade();
            //notify success message
        }
        else {
            //notify fail message
        }
    }
    
    public void buyFood(int qty) {
        if (coins>=getFood().getCurrentPrice()*qty) {
            getFood().updateQuantity(qty);
            coins -= getFood().getCurrentPrice()*qty;
            //notify success
        }
        else {
            //notify fail
        }
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public Toy getToy() {
        return (Toy)productCollection.get(0);
    }
    
    public Soap getSoap() {
        return (Soap)productCollection.get(1);
    }
            
    public Food getFood() {
        return (Food)productCollection.get(2);
    }

    /**
     * @return the pet
     */
    public Animal getPet() {
        return pet;
    }

    /**
     * @param pet the pet to set
     */
    public void setPet(Animal pet) {
        this.pet = pet;
    }
}
