/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS X202E
 */
public class Toy extends Product {
    public Toy() {
        this.name = "Small Toy";
        this.description = "Increases happiness by 10 points";
        this.upgradePrice = 100;
        this.index = 0.1;
        this.level = 1;
    }

    @Override
    public void changeLevel(int lvl) {
       if (lvl==1) {
            setName("Small Toy");
            setDescription("Increases happiness by 10 points");
            setUpgradePrice(100);
            setIndex(0.1);
            setLevel(1);
        }
        else if (lvl==2) {
            setName("Medium Toy");
            setDescription("Increases happiness by 20 points");
            setUpgradePrice(200);
            setIndex(0.2);
            setLevel(2);
        }
        else if (lvl==3) {
            setName("Large Toy");
            setDescription("Increases happiness by 30 points");
            setUpgradePrice(99999999);
            setIndex(0.3);
            setLevel(3);
        }
    }
}
