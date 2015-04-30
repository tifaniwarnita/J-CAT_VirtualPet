package virtualpet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * Nama File : Player.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public class Player implements Subject {
    private String playerName;
    private int coins;
    private Animal pet;
    private ArrayList<Product> productCollection = new ArrayList<>();
    private Random rand = new Random();
    private ArrayList<Observer> observers = new ArrayList<>();
    private boolean changed;
    private final Object MUTEX= new Object();

    public Player() {
        this.coins = 0;
        this.playerName = "";
        this.pet = new Animal();
        productCollection.add(new Toy());
        productCollection.add(new Soap());
        productCollection.add(new Food());
    }
    public Player(String name) {
        this.coins = 0;
        this.playerName = name;
        this.pet = new Animal();
        productCollection.add(new Toy());
        productCollection.add(new Soap());
        productCollection.add(new Food());
    }
    
  public void loadPlayer(String _name, int _coins, int toylevel, int soaplevel, int foodlevel, int foodqty) {
        setPlayerName(_name);
        setCoins(_coins);
        getToy().changeLevel(toylevel);
        getSoap().changeLevel(soaplevel);
        getFood().changeLevel(foodlevel);
        getFood().setQuantity(foodqty);
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
    
    public void adoptPet (String _name, String _type) {
        this.pet.setAnimal(_name, _type);
    }
    
    public void feedPet() {
        changed = true;
        if (getFood().getQuantity()>=1) {
            getPet().eatFood(getFood());
            getFood().updateQuantity(-1);
            setCoins(getCoins()+rand.nextInt(getFood().getLevel()*5)+1);
            notifyObservers("FEEDPET");
        } else
            notifyObservers("Not enough food");
    }
    
    public void cleanPet() {
        if (pet.getHygiene()<100) {
           getPet().cleanBody(getSoap());
           setCoins(getCoins()+rand.nextInt(getSoap().getLevel()*5)+1);
           changed = true;
           notifyObservers("CLEANPET");
        }
    }
    
    public void playPet() {
        if (pet.getHappiness()<100) {
            getPet().playGame(getToy()); 
            setCoins(getCoins()+rand.nextInt(getToy().getLevel()*5)+1);
            changed = true;
            notifyObservers("PLAYPET");
        }
    }
    
    
    public void upgradeFood() {
        if (coins>=getFood().getUpgradePrice()) {
            coins-=getFood().getUpgradePrice();
            getFood().upgrade();
            notifyObservers("UPGRADEFOOD");
        } else {
        	notifyObservers("NOTENOUGHCOINS");
        }
        changed=true;
    }
    
    public void upgradeSoap() {
    	changed = true;
        if (coins>=getSoap().getUpgradePrice()) {
            coins-=getSoap().getUpgradePrice();
            getSoap().upgrade();
            notifyObservers("UPGRADESOAP");
        } else {
        	notifyObservers("NOTENOUGHCOINS");
        }
        changed=true;
    }
    
    public void upgradeToy() {
        if (coins>=getToy().getUpgradePrice()) {
            coins-=getToy().getUpgradePrice();
            getToy().upgrade();
            notifyObservers("UPGRADETOY");
        } else {
        	notifyObservers("NOTENOUGHCOINS");
        }
        changed=true;
    }
    
    public void buyFood(int qty) {
        if (coins>=getFood().getCurrentPrice()*qty) {
            getFood().updateQuantity(qty);
            coins -= getFood().getCurrentPrice()*qty;
            notifyObservers("BUYFOOD");
        } else {
        	notifyObservers("NOTENOUGHCOINS");
        }
        changed=true;
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
    
    @Override
    public void registerObserver(Observer ob) {
        if(ob == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
        if(!observers.contains(ob)) {
                getObservers().add(ob);
            ob.setSubject(this);
        }
        }
    }
    
    @Override
    public void unregisterObserver(Observer ob) {
        synchronized (MUTEX) {
            getObservers().remove(ob);
            ob.setSubject(null);
        }
    }
    
    @Override
    public void notifyObservers(String message) {
        ArrayList<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.getObservers());
            this.changed=false;
        }
        for (Observer ob : observersLocal) {
            ob.update(message);
        }
    }

    /**
     * @return the observers
     */
    public ArrayList<Observer> getObservers() {
        return observers;
    }

    /**
     * @param observers the observers to set
     */
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    
    
}