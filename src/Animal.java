
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tifani
 */
public class Animal implements Subject, Runnable {
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
    
    public Animal() {
        this.name = null;
        this.hunger = 100;
        this.happiness = 100;
        this.health = 100;
        this.hygiene = 100;
        this.state = 0;
        //Animal View
        this.type = null;
        this.observers = new ArrayList<>();
    }
    
    public void setAnimal (String name, String type) {
        this.name = name;
        this.type = type;
        Thread t = new Thread(this);
        t.start();
    }
    
    public void loadAnimal (String name, String type, int hunger, int happiness, int health, int hygiene, int state) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.health = health;
        this.hygiene = hygiene;
        this.state = state;
        //Animal View
        this.type = type;
        this.changed = false; //TODO
        Thread t = new Thread(this);
        t.start();
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
        if (this.getHunger()>0)
            this.setHunger(this.getHunger()-1);
        if (this.getHappiness()>0)
            this.setHappiness(this.getHappiness()-1);
        if (this.getHygiene()>0)
            this.setHygiene(this.getHygiene()-1);
        if (this.getHealth()>0)
            this.setHealth(this.getHealth()-1);
        this.changed = true;
        notifyObservers("Reduce status");
    }
    
    public void reduceStatusWhenSleep() {
        if (this.getHunger()>0)
            this.setHunger(this.getHunger()-1);
        if (this.getHappiness()>0)
            this.setHappiness(this.getHappiness()-1);
        if (this.getHygiene()>0)
            this.setHygiene(this.getHygiene()-1);
        if (this.getHealth()<100)
            this.setHealth(this.getHealth()+5);
        this.changed = true;
        notifyObservers("Reduce status");
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

    @Override
    public void run() {
        while(true) {
            while (this.state==0) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (this.state==1)
                    break;
                reduceAllStatus();
            }
            while (this.state==1) { //sleep mode
                try {
                    Thread.sleep(2500);
                    if (this.state==0)
                        break;
                    Thread.sleep(2500);
                    if (this.state==0)
                        break;
                    Thread.sleep(2500);
                    if (this.state==0)
                        break;
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (this.state==0)
                    break;
                reduceStatusWhenSleep();
            }
            
        }
    }
}
