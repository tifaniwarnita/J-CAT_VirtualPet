
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
public class GameView extends JPanel implements Observer, Runnable {
    private Subject player;
    private AnimalView animalView;
    private String condition;
    private String defaultImage;
    private String winkImage;
    private String satisfiedImage1;
    private String satisfiedImage2;
    private String activeImage;
    private boolean action = false;
    
    public GameView() {
        //wink mode
        this.winkImage = ("../design/cat4.png");
        //satisfied mode
        this.satisfiedImage1 = ("../design/cat2.png");
        this.satisfiedImage2 = ("../design/cat3.png");
        this.defaultImage = ("../design/cat1.png");
        /*Animal cat = new Animal("Tifani", "Bruno");
        DummyCatView dcv = new DummyCatView(iAnimalFullBody, cat);
        Thread th = new Thread(dcv);
        th.start();*/        
    }
    
    public void setView(AnimalView animalView) {
        this.animalView = animalView;
        initComponents();
    }

    @Override
    public void update(Object args) {
        
    }

    @Override
    public void setSubject(Subject sub) {
        this.player = sub;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        tAnimal = new javax.swing.JLabel();
        bMainMenu = new javax.swing.JButton();
        bInventory = new javax.swing.JButton();
        iCoins = new javax.swing.JLabel();
        tCoins = new javax.swing.JLabel();
        bPlay = new javax.swing.JButton();
        bFeed = new javax.swing.JButton();
        bClean = new javax.swing.JButton();
        bSleep = new javax.swing.JButton();
        iAnimalFullBody = new javax.swing.JLabel();
        tHelloText = new javax.swing.JLabel();
        tHungerIndex = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tHappinessIndex = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tHygieneIndex = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tHealthIndex = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 235));
        setPreferredSize(new java.awt.Dimension(800, 480));

        tAnimal.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 48)); // NOI18N
        tAnimal.setForeground(new java.awt.Color(58, 65, 141));
        tAnimal.setText(this.animalView.getAnimal().getName());

        bMainMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bMainMenu.png")); // NOI18N
        bMainMenu.setContentAreaFilled(false);
        bMainMenu.setBorderPainted(false);
        bMainMenu.setPreferredSize(new java.awt.Dimension(159, 65));
        bMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMainMenuMouseClicked(evt);
            }
        });

        bInventory.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bInventory.png")); // NOI18N
        bInventory.setContentAreaFilled(false);
        bInventory.setBorderPainted(false);
        bInventory.setPreferredSize(new java.awt.Dimension(159, 65));
        bInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bInventoryMouseClicked(evt);
            }
        });

        iCoins.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\Coins.png")); // NOI18N

        tCoins.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 36)); // NOI18N
        tCoins.setForeground(new java.awt.Color(233, 181, 70));
        tCoins.setText("125");

        bPlay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bPlay.png")); // NOI18N
        bPlay.setContentAreaFilled(false);
        bPlay.setBorderPainted(false);
        bPlay.setPreferredSize(new java.awt.Dimension(133, 46));
        bPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPlayMouseClicked(evt);
            }
        });

        bFeed.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bFeed.png")); // NOI18N
        bFeed.setContentAreaFilled(false);
        bFeed.setBorderPainted(false);
        bFeed.setPreferredSize(new java.awt.Dimension(133, 46));
        bFeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bFeedMouseClicked(evt);
            }
        });

        bClean.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bClean.png")); // NOI18N
        bClean.setContentAreaFilled(false);
        bClean.setBorderPainted(false);
        bClean.setPreferredSize(new java.awt.Dimension(133, 46));
        bClean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCleanMouseClicked(evt);
            }
        });

        bSleep.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\bSleep.png")); // NOI18N
        bSleep.setContentAreaFilled(false);
        bSleep.setBorderPainted(false);
        bSleep.setPreferredSize(new java.awt.Dimension(133, 46));
        bSleep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSleepMouseClicked(evt);
            }
        });

        iAnimalFullBody.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\cat5.png")); // NOI18N

        tHelloText.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 36)); // NOI18N
        tHelloText.setForeground(new java.awt.Color(186, 95, 125));
        tHelloText.setText("Hello, ");

        tHungerIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHungerIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHungerIndex.setText("Hunger: " + this.animalView.getAnimal().getHunger());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHappinessIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHappinessIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHappinessIndex.setText("Happiness: " + this.animalView.getAnimal().getHappiness());

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHygieneIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHygieneIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHygieneIndex.setText("Hgygiene: " + this.animalView.getAnimal().getHygiene());

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHealthIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHealthIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHealthIndex.setText("Health: " + this.animalView.getAnimal().getHealth());

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tHelloText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(iCoins)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCoins))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tHungerIndex)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(bInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tHygieneIndex)
                                    .addComponent(jLabel5)
                                    .addComponent(tHappinessIndex)
                                    .addComponent(jLabel4)
                                    .addComponent(tHealthIndex)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(iAnimalFullBody, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(tAnimal)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tHelloText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tAnimal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iCoins)
                            .addComponent(tCoins))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tHungerIndex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tHappinessIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(bPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tHygieneIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(bClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tHealthIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(bSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iAnimalFullBody, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void bMainMenuMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void bInventoryMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void bFeedMouseClicked(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
        this.action = true;
    }                                  

    private void bPlayMouseClicked(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
    }                                  

    private void bCleanMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void bSleepMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
    }              
    
    @Override
    public void run() {
        while (true) {
            while (this.action==false) {
                try {
                    Thread.sleep(2000);
                    this.iAnimalFullBody.setIcon(new ImageIcon(this.animalView.getWinkImage()));
                    if (this.action==true)
                        break;
                    repaint();
                    Thread.sleep(500);
                    if (this.action==true)
                        break;
                    this.iAnimalFullBody.setIcon(new ImageIcon(this.animalView.getDefaultImage()));
                    if (this.action==true)
                        break;
                    repaint();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //suatu aksi sedang dilakukan
            try {
                Thread.sleep(300);
                this.iAnimalFullBody.setIcon(new ImageIcon(this.satisfiedImage1));
                repaint();
                Thread.sleep(300);
                this.iAnimalFullBody.setIcon(new ImageIcon(this.satisfiedImage2));
                repaint();
                Thread.sleep(800);
                this.iAnimalFullBody.setIcon(new ImageIcon(this.satisfiedImage1));
                repaint();
                Thread.sleep(300);
                this.iAnimalFullBody.setIcon(new ImageIcon(this.defaultImage));
                repaint();
                this.action = false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton bClean;
    private javax.swing.JButton bFeed;
    private javax.swing.JButton bInventory;
    private javax.swing.JButton bMainMenu;
    private javax.swing.JButton bPlay;
    private javax.swing.JButton bSleep;
    private javax.swing.JLabel iCoins;
    private javax.swing.JLabel iAnimalFullBody;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel tAnimal;
    private javax.swing.JLabel tCoins;
    private javax.swing.JLabel tHappinessIndex;
    private javax.swing.JLabel tHealthIndex;
    private javax.swing.JLabel tHelloText;
    private javax.swing.JLabel tHungerIndex;
    private javax.swing.JLabel tHygieneIndex;
    // End of variables declaration 
    
}


