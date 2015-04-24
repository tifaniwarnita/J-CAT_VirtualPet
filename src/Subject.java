
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public interface Subject {
    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);
    
    //methods to notify observers of change
    public void notifyObserver();
    
    //methods to get update from subject
    public Object getUpdate(Observer obj);
    
}
