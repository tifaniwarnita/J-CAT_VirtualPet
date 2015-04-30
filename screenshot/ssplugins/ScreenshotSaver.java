/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenshot.ssplugins;
import java.io.File;
import javax.swing.JLayeredPane;

/**
 *
 * @author ASUS X202E
 */
public interface ScreenshotSaver {
    public String[] typeExtensions();
    public String typeDescription();
    public boolean isSupported(File file);
    public void saveScreenshot(File file, JLayeredPane gameView);
}
