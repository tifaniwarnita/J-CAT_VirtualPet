/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS X202E
 */
abstract class Product {
    protected String name;
    protected String description;
    protected int upgradePrice;
    protected double index;
    protected int level;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the upgradePrice
     */
    public int getUpgradePrice() {
        return upgradePrice;
    }

    /**
     * @param upgradePrice the upgradePrice to set
     */
    public void setUpgradePrice(int upgradePrice) {
        this.upgradePrice = upgradePrice;
    }

    /**
     * @return the index
     */
    public double getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(double index) {
        this.index = index;
    }
    
    abstract void upgrade();

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
