
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tifani
 */
public class Animal implements Subject{
    private String name;
    private int hunger;
    private int happiness;
    private int health;
    private int hygiene;
    private int state; //bangun = 0, tidur = 1
    private List<Observer> observers;
    private String type;
    private Object MUTEX = new Object();
    private boolean changed;
    
    /**
     *
     * @param name adalah nama binatang yang akan dibuat
     * @param category adalah jenis binatang yang akan dibuat (misalnya kucing atau anjing)
     */
    public Animal (String name, String type) {
        this.name = name;
        this.hunger = 100;
        this.happiness = 100;
        this.health = 100;
        this.hygiene = 100;
        this.state = 0;
        //Animal View
        this.type = type;
        this.observers = new ArrayList<>();
        this.changed = false; //TODO
    }
    
    public Animal (String name, String type, int hunger, int happiness, int health, int hygiene, int state) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.health = health;
        this.hygiene = hygiene;
        this.state = state;
        //Animal View
        this.type = type;
        this.observers = new ArrayList<>();
        this.changed = false; //TODO
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hunger
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * @param hunger the hunger to set
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * @return the happiness
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * @param happiness the happiness to set
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the hygiene
     */
    public int getHygiene() {
        return hygiene;
    }

    /**
     * @param hygiene the hygiene to set
     */
    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the observers
     */
    public List<Observer> getObservers() {
        return observers;
    }

    /**
     * @param observers the observers to set
     */
    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the changed
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * @param changed the changed to set
     */
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    
    public void performMovement() {
        //TODO
        this.setChanged(true);
        notifyObservers("Perform movement");
    }
    
    public void eatFood(Food f) {
        this.setHunger((int) (this.getHunger()+f.getIndex()*100));
        if (this.getHunger()>100)
            this.setHunger(100);
        this.setChanged(true);
        notifyObservers("Eat food");
    }
    
    public void cleanBody(Soap s) {
        this.setHygiene((int) (this.getHygiene()+s.getIndex()*100));
        if (this.getHygiene()>100)
            this.setHygiene(100);
        this.setChanged(true);
        notifyObservers("Clean body");
    }
    
    public void playGame(Toy t) {
        this.setHappiness((int) (this.getHappiness()+t.getIndex()*100));
        if (this.getHappiness()>100)
            this.setHappiness(100);
        this.setChanged(true);
        notifyObservers("Play game");
    }
    
    public void sleep() {
        this.setState(1);
        this.setChanged(true);
        notifyObservers("Sleep");
    }
    
    public void wakeUp() {
        this.setState(0);
        this.setChanged(true);
        notifyObservers("Wake up");
    }
    
    public void reduceAllStatus() {
        //TODO
    }

    @Override
    public void registerObserver(Observer obj) {
        if (obj==null)
            throw new NullPointerException("Null Observer");
        synchronized (getMUTEX()) {
            if(!observers.contains(obj)) {
                getObservers().add(obj);
                obj.setSubject(this);
            }
        }
    }

    @Override
    public void unregisterObserver(Observer obj) {
        synchronized (getMUTEX()) {
            getObservers().remove(obj);
        }
    }

    @Override
    public void notifyObservers(String arg) {
        List<Observer> observersLocal = null;
        //sinkronisasi digunakan untuk memastikan bahwa setiap observer yang terregister setelah pesan diterima tidak ternotify
        synchronized (getMUTEX()) {
            if(!isChanged())
                return;
            observersLocal = new ArrayList<>(this.getObservers());
            this.setChanged(false);
        }
        for (Observer obj : observersLocal) {
            obj.update(arg);
        }
    }    

    /**
     * @return the MUTEX
     */
    public Object getMUTEX() {
        return MUTEX;
    }

    /**
     * @param MUTEX the MUTEX to set
     */
    public void setMUTEX(Object MUTEX) {
        this.MUTEX = MUTEX;
    }
}
