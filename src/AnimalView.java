
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
public abstract class AnimalView extends JPanel implements Observer {
    protected String condition;

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
        }
            
    }

    @Override
    public void setSubject(Subject sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void changeToHappy() {
        
    }
    
    public void changeToNormal() {
        
    }
    
    public void changeToSad() {
        
    }
}
