
import java.awt.Dimension;
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
public class StatusView extends JPanel implements Observer {
    private Animal animal;
    private javax.swing.JLabel progressBarHappiness;
    private javax.swing.JLabel progressBarHealth;
    private javax.swing.JLabel progressBarHunger;
    private javax.swing.JLabel progressBarHygiene;
    private javax.swing.JLabel tHappinessIndex;
    private javax.swing.JLabel tHealthIndex;
    private javax.swing.JLabel tHungerIndex;
    private javax.swing.JLabel tHygieneIndex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    
    public StatusView() {
    }
    
    public Animal getAnimal() {
        return this.animal;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        this.setOpaque(false);
        progressBarHygiene = new javax.swing.JLabel();
        tHealthIndex = new javax.swing.JLabel();
        progressBarHealth = new javax.swing.JLabel();
        tHungerIndex = new javax.swing.JLabel();
        progressBarHunger = new javax.swing.JLabel();
        tHappinessIndex = new javax.swing.JLabel();
        progressBarHappiness = new javax.swing.JLabel();
        tHygieneIndex = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        
        

        progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png")); // NOI18N

        tHealthIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHealthIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHealthIndex.setText("Health:");

        progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png")); // NOI18N

        tHungerIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHungerIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHungerIndex.setText("Hunger:");
        
        progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png")); // NOI18N

        tHappinessIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHappinessIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHappinessIndex.setText("Happiness:");
        

        progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png")); // NOI18N

        tHygieneIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHygieneIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHygieneIndex.setText("Hgygiene:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tHungerIndex)
                    .addComponent(tHygieneIndex)
                    .addComponent(tHappinessIndex)
                    .addComponent(tHealthIndex)
                    .addComponent(progressBarHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarHunger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarHappiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarHygiene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(445, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(tHungerIndex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressBarHunger)
                .addGap(10, 10, 10)
                .addComponent(tHappinessIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarHappiness)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tHygieneIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarHygiene)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tHealthIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarHealth)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>     

    @Override
    public void update(String args) {
        if (args.equals("Eat food"))
            calculateHungerStatus();
        else if (args.equals("Clean body"))
            calculateHygieneStatus();
        else if (args.equals("Play game"))
            calculateHappinessStatus();
        else if (args.equals("Reduce status")) {
            calculateHungerStatus();
            calculateHygieneStatus();
            calculateHappinessStatus();
            calculateHealthStatus();
        }
    }

    @Override
    public void setSubject(Subject sub) {
        setAnimal((Animal) sub);
        initComponents();
        calculateHungerStatus();
        calculateHygieneStatus();
        calculateHappinessStatus();
        calculateHealthStatus();
    }
    
    public void calculateHungerStatus() {
        this.tHungerIndex.setText("Hunger: " + this.animal.getHunger());
        if (animal.getHunger()==100)
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Bar100.png"));
        else if (animal.getHunger()>=85)
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Bar80.png"));
        else if (animal.getHunger()>=70)
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Bar60.png"));
        else if (animal.getHunger()>=35)
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Bar40.png"));
        else if (animal.getHunger()>=0)
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Bar20.png"));
        else
            this.progressBarHunger.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png"));
    }
    
    public void calculateHappinessStatus() {
        this.tHappinessIndex.setText("Happiness: " + this.animal.getHappiness());
        if (animal.getHappiness()==100)
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Bar100.png"));
        else if (animal.getHappiness()>=85)
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Bar80.png"));
        else if (animal.getHappiness()>=70)
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Bar60.png"));
        else if (animal.getHappiness()>=35)
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Bar40.png"));
        else if (animal.getHappiness()>=0)
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Bar20.png"));
        else
            this.progressBarHappiness.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png"));
    }
    
    public void calculateHygieneStatus() {
        this.tHygieneIndex.setText("Hygiene: " + this.animal.getHygiene());
        if (animal.getHygiene()==100)
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Bar100.png"));
        else if (animal.getHygiene()>=85)
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Bar80.png"));
        else if (animal.getHygiene()>=70)
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Bar60.png"));
        else if (animal.getHygiene()>=35)
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Bar40.png"));
        else if (animal.getHygiene()>=0)
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Bar20.png"));
        else
            this.progressBarHygiene.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png"));
    }
    
    public void calculateHealthStatus() {
      this.tHealthIndex.setText("Health: " + this.animal.getHealth());
        if (animal.getHealth()==100)
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Bar100.png"));
        else if (animal.getHealth()>=85)
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Bar80.png"));
        else if (animal.getHealth()>=70)
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Bar60.png"));
        else if (animal.getHealth()>=35)
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Bar40.png"));
        else if (animal.getHealth()>=0)
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Bar20.png"));
        else
            this.progressBarHealth.setIcon(new javax.swing.ImageIcon("../design/Status/Blank.png"));
    }
}
