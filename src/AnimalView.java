
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
public class AnimalView implements Observer {
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
        //wink mode
        this.winkImage = ("../design/Animal/"+this.animal.getType()+"/Close.png");
        //satisfied mode
        this.satisfiedImage1 = ("../design/Animal/"+this.animal.getType()+"/Satisfied.png");
        this.satisfiedImage2 = ("../design/Animal/"+this.animal.getType()+"/Satisfied2.png");
        this.defaultImage = calculateHappiness();
    }
    
    public String calculateHappiness() {
        int totalStatus = this.animal.getHappiness() + this.animal.getHealth() + this.animal.getHunger() + this.animal.getHygiene();
        if (totalStatus > 250) //Happy
            return ("../design/Animal/"+this.animal.getType()+"/Happy.png");
        else if (totalStatus > 140)
            return ("../design/Animal/"+this.animal.getType()+"/Normal.png");
        else
            return ("../design/Animal/"+this.animal.getType()+"/Sad.png");
    }
}