
import java.awt.Image;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class AnimalView implements Observer, Runnable {
    private Animal animal;
    private String defaultImage;
    private String winkImage;
    private String satisfiedImage1;
    private String satisfiedImage2;
    private String activeImage;
  
    public AnimalView() {
        this.animal = null;
        this.defaultImage = null;
        this.winkImage = null;
        this.satisfiedImage1 = null;
        this.satisfiedImage2 = null;
        this.activeImage = null;
    }
    
    public Animal getAnimal() {
        return animal;
    }
    
    private void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    /**
     * @return the defaultImage
     */
    public String getDefaultImage() {
        return defaultImage;
    }

    /**
     * @param defaultImage the defaultImage to set
     */
    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    /**
     * @return the winkImage
     */
    public String getWinkImage() {
        return winkImage;
    }

    /**
     * @param winkImage the winkImage to set
     */
    public void setWinkImage(String winkImage) {
        this.winkImage = winkImage;
    }

    /**
     * @return the satisfiedImage1
     */
    public String getSatisfiedImage1() {
        return satisfiedImage1;
    }

    /**
     * @param satisfiedImage1 the satisfiedImage1 to set
     */
    public void setSatisfiedImage1(String satisfiedImage1) {
        this.satisfiedImage1 = satisfiedImage1;
    }

    /**
     * @return the satisfiedImage2
     */
    public String getSatisfiedImage2() {
        return satisfiedImage2;
    }

    /**
     * @param satisfiedImage2 the satisfiedImage2 to set
     */
    public void setSatisfiedImage2(String satisfiedImage2) {
        this.satisfiedImage2 = satisfiedImage2;
    }

    /**
     * @return the activeImage
     */
    public String getActiveImage() {
        return activeImage;
    }

    /**
     * @param activeImage the activeImage to set
     */
    public void setActiveImage(String activeImage) {
        this.activeImage = activeImage;
    }

    @Override
    public void update(Object args) {
        calculateHappiness();
    }

    @Override
    public void setSubject(Subject sub) {
        setAnimal((Animal) sub);
        if (animal.getType().equals("Cat")) {
            //wink mode
            this.winkImage = ("../design/cat4.png");
            //satisfied mode
            this.satisfiedImage1 = ("../design/cat2.png");
            this.satisfiedImage2 = ("../design/cat3.png");
            this.defaultImage = calculateHappiness();
        }
        else { //is a dog
            this.winkImage = ("../design/dog4.png");
            //satisfied mode
            this.satisfiedImage1 = ("../design/dog2.png");
            this.satisfiedImage2 = ("../design/dog3.png");
            this.defaultImage = calculateHappiness();
        }
    }
    
    public String calculateHappiness() {
        int totalStatus = this.animal.getHappiness() + this.animal.getHealth() + this.animal.getHunger() + this.animal.getHygiene();
        if (totalStatus > 250) //Happy
            return ("../design/cat1.png");
        else if (totalStatus > 140)
            return ("../design/cat5.png");
        else
            return ("../design/cat6.png");
    }

    @Override
    public void run() {
        while (this.animal!=null) {
            calculateHappiness();
        }
    }
}
