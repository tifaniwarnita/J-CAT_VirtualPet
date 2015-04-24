
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class CatView extends AnimalView {  

    public CatView(String condition) {
        super.action = false;
        initializePictureComponent();
        super.update(condition);
        super.activeImage = super.defaultImage;
    }
    
    @Override
    public void changeToHappy() {
        ImageIcon image = new ImageIcon("../design/cat1.png");
        super.defaultImage = image.getImage();
    }
    
    @Override
    public void changeToNormal() {
        ImageIcon image = new ImageIcon("../design/cat5.png");
        super.defaultImage = image.getImage();
    }
    @Override 
    public void changeToSad() {
        ImageIcon image = new ImageIcon("../design/cat6.png");
        super.defaultImage = image.getImage();
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(super.activeImage, 0, 0, null);
    }
    
    @Override
    public void initializePictureComponent() {
        //wink mode
        ImageIcon image = new ImageIcon("../design/cat4.png");
        super.winkImage = image.getImage();
        //satisfied mode
        image = new ImageIcon("../design/cat2.png");
        super.satisfiedImage1 = image.getImage();
        image = new ImageIcon("../design/cat3.png");
        super.satisfiedImage2 = image.getImage();
        //int w = this.catPicture.getWidth(this);
        //int h = this.catPicture.getHeight(this);
        //setPreferredSize(new Dimension(w,h));
    }

    @Override
    public void run() {
        while (true) {
            while (super.action==false) {
                try {
                    Thread.sleep(2000);
                    super.activeImage = super.winkImage;
                    repaint();
                    Thread.sleep(500);
                    super.activeImage = super.defaultImage;
                    repaint();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //suatu aksi sedang dilakukan
            try {
                Thread.sleep(300);
                super.activeImage = super.satisfiedImage1;
                repaint();
                Thread.sleep(300);
                super.activeImage = super.satisfiedImage2;
                repaint();
                Thread.sleep(800);
                super.activeImage = super.satisfiedImage1;
                repaint();
                Thread.sleep(300);
                super.activeImage = super.defaultImage;
                repaint();
                super.action = false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
