/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Tifani
 */
public class AnimalSound implements Observer{
    private Animal animal;
    private Clip clipSleep;
    
    public AnimalSound() {
        try {
            this.clipSleep = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/virtualpet/sound/snore.wav"));
            this.clipSleep.open(inputStream);
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(String args) {
        if (args.equals("Eat food") || args.equals("Clean body") || args.equals("Play game")) {
            Clip clipEffect;
            try {
                clipEffect = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        getClass().getResource("/virtualpet/sound/"+this.animal.getType()+".wav"));
                clipEffect.open(inputStream);
                clipEffect.start();
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
        }
        else if (args.equals("Sleep")) {
            try {
                this. clipSleep.start(); 
                this.clipSleep.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
        }
        else if (args.equals("Wake up")) {
            if (this.clipSleep.isRunning()) {
                this.clipSleep.stop();
            }
        }
            
            
    }

    @Override
    public void setSubject(Subject sub) {
        this.animal = (Animal) sub;
        if (this.animal.getState()==1)
            update("Sleep");
    }
}
