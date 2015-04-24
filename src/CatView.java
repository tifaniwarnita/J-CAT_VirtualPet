
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

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
    private Image catPicture;
    
    public CatView(String condition) {
        super.update(condition);
    }
    
    @Override
    public void changeToHappy() {
        ImageIcon image = new ImageIcon("../design/cat1.png");
        catPicture = image.getImage();
        int w = this.catPicture.getWidth(this);
        int h = this.catPicture.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }
    
    @Override
    public void changeToNormal() {
        
    }
    @Override
    public void changeToSad() {
        
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(catPicture, 0, 0, null);
    }
}
