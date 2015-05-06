/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet.ssplugins;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS X202E
 */
public class ScreenshotSaverJPEG implements ScreenshotSaver {
    @Override
    public String[] typeExtensions() {
        String[] types = {"jpg","jpeg"};
        return types;
    }
    @Override
    public String typeDescription() {
        return "JPEG Image (*.jpg, *.jpeg)";
    }
    @Override
    public boolean isSupported(File file) {
        return (file.getName().endsWith("jpg") || file.getName().endsWith("jpeg"));
    }
    
    @Override
    public void saveScreenshot(File file, Rectangle screenRect) {
        BufferedImage capture;
        try {
            capture = new Robot().createScreenCapture(screenRect);
            ImageIO.write(capture, "jpg", file);
        } catch (AWTException ex) {
            Logger.getLogger(ScreenshotSaverJPEG.class.getName()).log(Level.SEVERE, null, ex);  
       } catch (IOException ioe) {
            System.out.println(ioe);
        } 
    }
}
