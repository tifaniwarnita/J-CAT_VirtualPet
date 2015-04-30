/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Tifani
 */
public class VirtualPetSound implements Observer{
    private Animal animal;
    private Clip clipMain;
    
    public VirtualPetSound() {
        try {
            this.clipMain = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/virtualpet/sound/maintheme.wav"));
            this.clipMain.open(inputStream);
            this.clipMain.start();
            this.clipMain.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(String args) {
        if (args.equals("Sleep")) {
            if(this.clipMain.isRunning())
                this.clipMain.stop();
            try {
                this.clipMain = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        getClass().getResource("/virtualpet/sound/sleeptheme.wav"));
                this.clipMain.open(inputStream);
                this.clipMain.start();
                this.clipMain.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
        }
        else if (args.equals("Wake up")) {
            if(this.clipMain.isRunning())
                this.clipMain.stop();
            try {
                this.clipMain = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        getClass().getResource("/virtualpet/sound/maintheme.wav"));
                this.clipMain.open(inputStream);
                this.clipMain.start();
                this.clipMain.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
              System.err.println(e.getMessage());
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
