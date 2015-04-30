/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenshot;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import screenshot.ssplugins.ScreenshotSaver;

/**
 *
 * @author ASUS X202E   
 */
public class Screenshot {
    private ArrayList<ScreenshotSaver> ssplugins = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public Screenshot() {
        loadPlugins();
    }
    public void loadPlugins() {
        File f = new File("C:\\Users\\ASUS X202E\\Documents\\NetBeansProjects\\Screenshot\\src\\screenshot\\ssplugins");
        String names[] = f.list();
            for (String name: names) {
                Class c;
                try {
                    c = Class.forName("screenshot.ssplugins."+name.substring(0,name.length()-5));
                    Class intfs[] = c.getInterfaces();
                    for (Class itf : intfs) {
                        if (itf.getName().equals("screenshot.ssplugins.ScreenshotSaver")) 
                        {
                               ScreenshotSaver s;
                            try {
                                s = (ScreenshotSaver)c.newInstance();
                                getSsplugins().add(s);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(Screenshot.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(Screenshot.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Screenshot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
           

    /**
     * @return the ssplugins
     */
    public ArrayList<ScreenshotSaver> getSsplugins() {
        return ssplugins;
    }

    /**
     * @param ssplugins the ssplugins to set
     */
    public void setSsplugins(ArrayList<ScreenshotSaver> ssplugins) {
        this.ssplugins = ssplugins;
    }
}