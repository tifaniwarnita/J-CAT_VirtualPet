package virtualpet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Nama File : Food.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public class Food extends Product {
    private int currentPrice;
    private int quantity;
    
    public Food() {
        this.name = "Small Food";
        this.description = "Reduces hunger by 10 points";
        this.upgradePrice = 100;
        this.index = 0.1;
        this.level = 1;
        this.quantity = 0;
        this.currentPrice = 5;
    }

    /**
     *
     */
    @Override
    public void changeLevel(int lvl) {
        if (lvl==1) {
            setName("Small Food");
            setDescription("Decreases hunger by 10 points");
            setUpgradePrice(100);
            setIndex(0.1);
            setLevel(1);
            setCurrentPrice(5);
        }
        else if (lvl==2) {
            setName("Medium Food");
            setDescription("Decreases hunger by 20 points");
            setUpgradePrice(200);
            setIndex(0.2);
            setLevel(2);
            setCurrentPrice(8);
        } else if (lvl==3) {
            setName("Large Food");
            setDescription("Increases hunger by 30 points");
            setUpgradePrice(99999999);
            setIndex(0.3);
            setLevel(3);
            setCurrentPrice(10);
        }
    }
    
    public void updateQuantity(int addqty) {
        quantity += addqty;
    }

    /**
     * @return the currentPrice
     */
    public int getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @param currentPrice the currentPrice to set
     */
    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
