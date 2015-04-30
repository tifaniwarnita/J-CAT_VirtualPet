package virtualpet;

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
    public void registerObserver(Observer obj);
    public void unregisterObserver(Observer obj);
    
    //methods to notify observers of change
    public void notifyObservers(String arg);
    
}
