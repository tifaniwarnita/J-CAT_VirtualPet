
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class AnimalView extends JPanel implements Observer, Runnable {
    private Animal animal;
    private String defaultImage;
    private String winkImage;
    private String satisfiedImage1;
    private String satisfiedImage2;
    private String activeImage;
    private String sleepImage1;
    private String sleepImage2;
    private boolean action;
    private String message;
    private javax.swing.JLabel iAnimalFullBody;
  
    public AnimalView() {
        this.animal = null;
        this.defaultImage = null;
        this.winkImage = null;
        this.satisfiedImage1 = null;
        this.satisfiedImage2 = null;
        this.activeImage = null;
        this.sleepImage1 = null;
        this.sleepImage2 = null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        iAnimalFullBody = new javax.swing.JLabel();

        iAnimalFullBody.setMaximumSize(new java.awt.Dimension(310, 350));
        iAnimalFullBody.setMinimumSize(new java.awt.Dimension(310, 350));
        iAnimalFullBody.setPreferredSize(new java.awt.Dimension(310, 350));
        
        this.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addComponent(iAnimalFullBody, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 109, Short.MAX_VALUE)
                .addComponent(iAnimalFullBody, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>       
    
    public Animal getAnimal() {
        return animal;
    }
    
    private void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    /**
     * @return the defaultImage
     */
    public String getDefaultImage() {
        return defaultImage;
    }

    /**
     * @param defaultImage the defaultImage to set
     */
    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    /**
     * @return the winkImage
     */
    public String getWinkImage() {
        return winkImage;
    }

    /**
     * @param winkImage the winkImage to set
     */
    public void setWinkImage(String winkImage) {
        this.winkImage = winkImage;
    }

    /**
     * @return the satisfiedImage1
     */
    public String getSatisfiedImage1() {
        return satisfiedImage1;
    }

    /**
     * @param satisfiedImage1 the satisfiedImage1 to set
     */
    public void setSatisfiedImage1(String satisfiedImage1) {
        this.satisfiedImage1 = satisfiedImage1;
    }

    /**
     * @return the satisfiedImage2
     */
    public String getSatisfiedImage2() {
        return satisfiedImage2;
    }

    /**
     * @param satisfiedImage2 the satisfiedImage2 to set
     */
    public void setSatisfiedImage2(String satisfiedImage2) {
        this.satisfiedImage2 = satisfiedImage2;
    }

    /**
     * @return the activeImage
     */
    public String getActiveImage() {
        return activeImage;
    }

    /**
     * @param activeImage the activeImage to set
     */
    public void setActiveImage(String activeImage) {
        this.activeImage = activeImage;
    }
    
    /**
     * @return the sleepImage1
     */
    public String getSleepImage1() {
        return sleepImage1;
    }

    /**
     * @param sleepImage1 the sleepImage1 to set
     */
    public void setSleepImage1(String sleepImage1) {
        this.sleepImage1 = sleepImage1;
    }
    
    /**
     * @return the sleepImage2
     */
    public String getSleepImage2() {
        return sleepImage2;
    }

    /**
     * @param sleepImage2 the sleepImage2 to set
     */
    public void setSleepImage2(String sleepImage2) {
        this.sleepImage2 = sleepImage2;
    }

    @Override
    public void update(String args) {
        this.defaultImage = calculateHappiness();
        this.action = true;
        this.message = args;
    }

    @Override
    public void setSubject(Subject sub) {
        setAnimal((Animal) sub);
        //wink mode
        this.winkImage = ("../design/Animal/"+this.animal.getType()+"/Close.png");
        this.sleepImage1 = ("../design/Animal/"+this.animal.getType()+"/Sleep1.png");
        this.sleepImage2 = ("../design/Animal/"+this.animal.getType()+"/Sleep2.png");
        //satisfied mode
        this.satisfiedImage1 = ("../design/Animal/"+this.animal.getType()+"/Satisfied.png");
        this.satisfiedImage2 = ("../design/Animal/"+this.animal.getType()+"/Satisfied2.png");
        this.defaultImage = calculateHappiness();
        initComponents();
        Thread t = new Thread(this);
        t.start();
    }
    
    public String calculateHappiness() {
        int totalStatus = this.animal.getHappiness() + this.animal.getHealth() + this.animal.getHunger() + this.animal.getHygiene();
        if (totalStatus > 250) //Happy
            return ("../design/Animal/"+this.animal.getType()+"/Happy.png");
        else if (totalStatus > 140)
            return ("../design/Animal/"+this.animal.getType()+"/Normal.png");
        else
            return ("../design/Animal/"+this.animal.getType()+"/Sad.png");
    }

    @Override
    public void run() {
        while (true) {
            while (this.action==false && this.animal.getState()==0) {
                try {
                    Thread.sleep(1000);
                    this.iAnimalFullBody.setIcon(new ImageIcon(getWinkImage()));
                    if (this.action==true)
                        break;
                    Thread.sleep(300);
                    if (this.action==true)
                        break;
                    this.iAnimalFullBody.setIcon(new ImageIcon(getDefaultImage()));
                    if (this.action==true)
                        break;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.animal.getState()==1) {
                this.action =false;
                while (this.action==false) {
                    try {
                        Thread.sleep(300);
                        this.iAnimalFullBody.setIcon(new ImageIcon(getWinkImage()));
                        if (this.action==true)
                            break;
                        Thread.sleep(300);
                        if (this.action==true)
                            break;
                        this.iAnimalFullBody.setIcon(new ImageIcon(getSleepImage1()));
                        if (this.action==true)
                            break;
                         Thread.sleep(300);
                        if (this.action==true)
                            break;
                        this.iAnimalFullBody.setIcon(new ImageIcon(getSleepImage2()));
                        if (this.action==true)
                            break;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //suatu aksi sedang dilakukan
            try {
                String obj = null;
                if (this.message.equals("Eat food"))
                    obj = "Food";
                else if (this.message.equals("Clean body"))
                    obj = "Soap";
                else if (this.message.equals("Play game"))
                    obj = "Toy";
                if (obj!=null) {
                    this.iAnimalFullBody.setIcon(new ImageIcon(("../design/Animal/"+this.animal.getType()+"/"+obj+"Happy.png")));
                    repaint();
                    Thread.sleep(300);
                    this.iAnimalFullBody.setIcon(new ImageIcon(("../design/Animal/"+this.animal.getType()+"/"+obj+"Satisfied.png")));
                    Thread.sleep(300);
                    this.iAnimalFullBody.setIcon(new ImageIcon(("../design/Animal/"+this.animal.getType()+"/"+obj+"Satisfied2.png")));
                    Thread.sleep(400);
                    this.iAnimalFullBody.setIcon(new ImageIcon(getDefaultImage()));
                }
                obj = null;
                this.action = false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
