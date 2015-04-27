
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class DummyCatView extends AnimalView{
    
    private JLabel animalImage;
    private Animal cat;
    private String condition;
    private String defaultImage;
    private String winkImage;
    private String satisfiedImage1;
    private String satisfiedImage2;
    private String activeImage;
    
    public DummyCatView(JLabel animalImage, Animal cat) {
        this.animalImage = animalImage;
        this.cat = cat;
        super.action = false;
        initializePictureComponent();
        //super.update(this.cat.getMessage());
    }
    
    @Override
    public void changeToHappy() {
        this.defaultImage = ("../design/cat1.png");
        this.animalImage.setIcon(new ImageIcon(this.defaultImage));
    }
    
    @Override
    public void changeToNormal() {
        this.defaultImage = ("../design/cat5.png");
        this.animalImage.setIcon(new ImageIcon(this.defaultImage));
    }
    @Override 
    public void changeToSad() {
        this.defaultImage = ("../design/cat6.png");
        this.animalImage.setIcon(new ImageIcon(this.defaultImage));
    }
    
    @Override
    public void initializePictureComponent() {
        //wink mode
        this.winkImage = ("../design/cat4.png");
        //satisfied mode
        this.satisfiedImage1 = ("../design/cat2.png");
        this.satisfiedImage2 = ("../design/cat3.png");
    }

    @Override
    public void run() {
        while (true) {
            while (super.action==false) {
                try {
                    Thread.sleep(2000);
                    this.animalImage.setIcon(new ImageIcon(this.winkImage));
                    repaint();
                    Thread.sleep(500);
                    this.animalImage.setIcon(new ImageIcon(this.defaultImage));
                    repaint();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //suatu aksi sedang dilakukan
            try {
                Thread.sleep(300);
                this.animalImage.setIcon(new ImageIcon(this.satisfiedImage1));
                repaint();
                Thread.sleep(300);
                this.animalImage.setIcon(new ImageIcon(this.satisfiedImage2));
                repaint();
                Thread.sleep(800);
                this.animalImage.setIcon(new ImageIcon(this.satisfiedImage1));
                repaint();
                Thread.sleep(300);
                this.animalImage.setIcon(new ImageIcon(this.defaultImage));
                repaint();
                super.action = false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
