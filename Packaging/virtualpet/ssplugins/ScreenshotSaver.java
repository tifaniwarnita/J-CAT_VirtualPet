/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualpet.ssplugins;
import java.awt.Rectangle;
import java.io.File;

/**
 *
 * @author ASUS X202E
 */
public interface ScreenshotSaver {
    public String[] typeExtensions();
    public String typeDescription();
    public boolean isSupported(File file);
    public void saveScreenshot(File file, Rectangle rect);
}
