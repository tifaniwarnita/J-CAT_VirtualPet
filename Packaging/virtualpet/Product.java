package virtualpet;

/**
 * Nama File : Product.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public abstract class Product {
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
    
    
    public void upgrade() {
        if (getLevel()==1) {
            changeLevel(2);
        } else if (getLevel()==2) {
            changeLevel(3);
        }
    }
    
    abstract void changeLevel(int lvl);

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
