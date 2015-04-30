package virtualpet;

/**
 * Nama File : Soap.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public class Soap extends Product {
    public Soap() {
        this.name = "Small Soap";
        this.description = "Increases hygiene by 10 points";
        this.upgradePrice = 100;
        this.index = 0.1;
        this.level = 1;
    }

    /**
     *
     * @param lvl
     */
    @Override
    public void changeLevel(int lvl) {
        if (lvl==1) {
            setName("Small Soap");
            setDescription("Increases hygiene by 10 points");
            setUpgradePrice(100);
            setIndex(0.1);
            setLevel(1);
        }
        if (lvl==2) {
            setName("Medium Soap");
            setDescription("Increases hygiene by 20 points");
            setUpgradePrice(200);
            setIndex(0.2);
            setLevel(2);
        } else if (lvl==3) {
            setName("Large Soap");
            setDescription("Increases hygiene by 30 points");
            setUpgradePrice(99999999);
            setIndex(0.3);
            setLevel(3);
        }
    }
}
