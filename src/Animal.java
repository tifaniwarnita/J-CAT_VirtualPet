/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet;

/**
 *
 * @author Tifani
 */
public class Animal {
    private String name;
    private int hunger;
    private int happiness;
    private int health;
    private int hygiene;
    private int state;
    //private View AnimalView;
    private String type;
    
    /**
     *
     * @param name adalah nama binatang yang akan dibuat
     * @param category adalah jenis binatang yang akan dibuat (misalnya kucing atau anjing)
     */
    public Animal (String name, String category) {
        this.name = name;
        this.hunger = 100;
        this.happiness = 100;
        this.health = 100;
        this.hygiene = 100;
        this.state = 100;
        //Animal View
        this.type = category;
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
    
    /* public void performMovement() {
        //TODO
    }
    
    public void eatFood(Food s) {
        this.setHunger(this.getHunger()+f.getIndex()*100);
        if (this.getHunger()>100)
            this.setHunger(100);
    }
    
    public void cleanBody(Soap s) {
        this.setHygiene
    }
    */
}
