/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package virtualpet;

/**
 *
 * @author ASUS X202E
 */
public class Toy extends Product {
    public Toy() {
        name = "Small Toy";
        description = "Increases happiness by 10 points";
        upgradePrice = 100;
        index = 0.1;
        level = 1;
    }

    /**
     *
     */
    @Override
    public void upgrade() {
        if (getLevel()==1) {
            setName("Medium Toy");
            setDescription("Increases happiness by 20 points");
            setUpgradePrice(200);
            setIndex(0.2);
            setLevel(2);
        } else if (getLevel()==2) {
            setName("Large Toy");
            setDescription("Increases happiness by 30 points");
            setUpgradePrice(99999999);
            setIndex(0.3);
            setLevel(3);
        }
    }
}
