/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class DummyCoinView extends javax.swing.JPanel {

    /**
     * Creates new form DummyCoinView
     */
    public DummyCoinView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBarHygiene = new javax.swing.JLabel();
        tHealthIndex = new javax.swing.JLabel();
        progressBarHealth = new javax.swing.JLabel();
        tHungerIndex = new javax.swing.JLabel();
        progressBarHunger = new javax.swing.JLabel();
        tHappinessIndex = new javax.swing.JLabel();
        progressBarHappiness = new javax.swing.JLabel();
        tHygieneIndex = new javax.swing.JLabel();

        progressBarHygiene.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHealthIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHealthIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHealthIndex.setText("Health:");

        progressBarHealth.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHungerIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHungerIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHungerIndex.setText("Hunger:");

        progressBarHunger.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHappinessIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHappinessIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHappinessIndex.setText("Happiness:");

        progressBarHappiness.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tifani\\Documents\\Tifani Warnita\\Schools - College\\ITB\\HMIF ITB\\Informatics Engineering\\Semester 4\\2014\\OOP - Pemrograman Berorientasi Objek\\J-CAT_VirtualPet\\design\\progressBar.png")); // NOI18N

        tHygieneIndex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tHygieneIndex.setForeground(new java.awt.Color(58, 65, 141));
        tHygieneIndex.setText("Hgygiene:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tHungerIndex)
                    .addComponent(tHygieneIndex)
                    .addComponent(tHappinessIndex)
                    .addComponent(tHealthIndex)
                    .addComponent(progressBarHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarHappiness, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressBarHygiene, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressBarHunger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(449, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel progressBarHappiness;
    private javax.swing.JLabel progressBarHealth;
    private javax.swing.JLabel progressBarHunger;
    private javax.swing.JLabel progressBarHygiene;
    private javax.swing.JLabel tHappinessIndex;
    private javax.swing.JLabel tHealthIndex;
    private javax.swing.JLabel tHungerIndex;
    private javax.swing.JLabel tHygieneIndex;
    // End of variables declaration//GEN-END:variables
}