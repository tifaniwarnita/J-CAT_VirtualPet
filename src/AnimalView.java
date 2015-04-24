
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
public abstract class AnimalView extends JPanel implements Observer, Runnable {
    protected String condition;
    protected Image defaultImage;
    protected Image winkImage;
    protected Image satisfiedImage1;
    protected Image satisfiedImage2;
    protected Image activeImage;
    protected boolean action = false;
    
    public String getCondition() {
        return this.condition;
    }
    
    public Image getActiveImage() {
        return this.activeImage;
    }

    @Override
    public void update(Object args) {
        if (((String)args).equals("Happy")) {
            this.condition = "Happy";
            changeToHappy();
        }
        else if (((String)args).equals("Normal")) {
            this.condition = "Normal";
            changeToNormal();
        }
        else if (((String)args).equals("Sad")) {
            this.condition = "Sad";
            changeToSad();
        } else {
            action = true;
            this.condition = "OBSERVER BERHASIL";
        }
            
    }

    @Override
    public void setSubject(Subject sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initializePictureComponent() {
        
    }
    
    public void changeToHappy() {
        
    }
    
    public void changeToNormal() {
        
    }
    
    public void changeToSad() {
        
    }
}
