package View;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserHomePage extends javax.swing.JFrame 
{
    public UserHomePage() 
    {
        initComponents();
        setTitle("User Homepage");//set the title of the jframe
        setSize(1800,900);// setting the size of the jframe
        jLabel18.setIcon(new ImageIcon("background4.jpg")); // set the background image for the jframe
        
    }
    public void setUsername(String username)
    {
        this.usernameHomePage.setText(username.toUpperCase());
    }
    public void setBalance(int balance)
    {
        String string = Integer.toString(balance);
        this.balance.setText(string);
    }
    public void setError(String error)
    {
        jLabel16.setText(error);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        purchaseBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        usernameHomePage = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setResizable(false);
        getContentPane().setLayout(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane2.addTab("Store", jScrollPane1);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane2.addTab("Song List", jScrollPane2);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(44, 133, 1352, 670);

        purchaseBtn.setText("Purchase");
        getContentPane().add(purchaseBtn);
        purchaseBtn.setBounds(1424, 765, 95, 38);

        jLabel3.setText("Genre             :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1424, 522, 105, 22);

        jLabel4.setText("Title               :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1424, 438, 105, 21);

        jLabel5.setText("Artist              :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1424, 468, 105, 16);

        jLabel6.setText("Album             :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1424, 491, 105, 24);

        jLabel7.setText("Price               :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1424, 551, 105, 22);

        jLabel1.setText("Popularity        : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1424, 580, 105, 20);

        jLabel8.setText("No Record Selected");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1536, 438, 175, 24);

        jLabel9.setText("No Record Selected");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1536, 468, 175, 19);

        jLabel10.setText("No Record Selected");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1536, 491, 175, 24);

        jLabel11.setText("No Record Selected");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1536, 526, 175, 18);

        jLabel12.setText("No Record Selected");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1536, 580, 175, 20);

        jLabel13.setText("No Record Selected");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1536, 554, 175, 19);

        jButton1.setText("Play ");
        getContentPane().add(jButton1);
        jButton1.setBounds(1424, 679, 80, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(110, 90, 504, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("BALANCE :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(920, 30, 130, 40);

        balance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        balance.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(balance);
        balance.setBounds(1040, 30, 180, 40);

        jButton2.setText("Top Up");
        getContentPane().add(jButton2);
        jButton2.setBounds(1325, 29, 90, 32);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1773, 713, 83, 52);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search   :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(44, 92, 57, 25);

        jLabel16.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabel16);
        jLabel16.setBounds(1424, 636, 394, 30);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1424, 179, 220, 241);

        jButton4.setText("Stop");
        getContentPane().add(jButton4);
        jButton4.setBounds(1424, 713, 80, 30);

        jButton3.setText("Sign Out");
        getContentPane().add(jButton3);
        jButton3.setBounds(1325, 101, 90, 30);

        usernameHomePage.setBackground(new java.awt.Color(255, 255, 255));
        usernameHomePage.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        usernameHomePage.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(usernameHomePage);
        usernameHomePage.setBounds(30, 20, 750, 60);
        getContentPane().add(jLabel18);
        jLabel18.setBounds(-20, -10, 2460, 170);

        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jLabel14);
        jLabel14.setBounds(1530, 770, 230, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.refresh();
         String title = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                System.out.println(title);
                String artist = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String album = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String genre = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                String popularity = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                String price = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
                ImageIcon icon = (ImageIcon) jTable1.getValueAt(jTable1.getSelectedRow(), 3);
                jLabel8.setText(title);
                jLabel9.setText(artist);
                jLabel10.setText(album);
                jLabel11.setText(genre);
                jLabel12.setText(popularity);
                jLabel13.setText(price);
                jLabel17.setIcon(icon);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        this.refresh();
        String title = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        System.out.println(title);
        String artist = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        String album = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();
        String genre = jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString();
        String popularity = jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString();
        String price = jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString();
        ImageIcon icon = (ImageIcon) jTable2.getValueAt(jTable2.getSelectedRow(), 3);
        jLabel8.setText(title);
        jLabel9.setText(artist);
        jLabel10.setText(album);
        jLabel11.setText(genre);
        jLabel12.setText(popularity);
        jLabel13.setText(price);
        jLabel17.setIcon(icon);
    }//GEN-LAST:event_jTable2MouseClicked
   public void keyRelease(KeyListener l){
        jTextField1.addKeyListener(l);
    }
    public void setActionListenerPurchaseBtn(ActionListener a)
    {
        purchaseBtn.addActionListener(a);
    }
    public void setActionListenerPlay(ActionListener a)
    {
        jButton1.addActionListener(a);
    }
    public void setActionListenerTopUp(ActionListener a)
    {
        jButton2.addActionListener(a);
    }
     public void setActionListenerStopAudio(ActionListener a)
    {
        jButton4.addActionListener(a);
    }
    public void setActionListenerSignOut(ActionListener a)
    {
        jButton3.addActionListener(a);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton purchaseBtn;
    private javax.swing.JLabel usernameHomePage;
    // End of variables declaration//GEN-END:variables
    public JTable getjTable1() {
        return jTable1;
    }
        
    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }
    public JLabel getBalance() {
        return balance;
    }
    public JLabel getjLabel1() {
        return jLabel1;
    }
    public JLabel getjLabel10() {
        return jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }
    public JLabel getjLabel14(){
        return jLabel14;
    }
    public void setjLabel14(String text)
    {
        this.jLabel14.setText(text);
    }
    public JPanel getPanel()
    {
        return jPanel3;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JButton getjButton1() {
        return jButton1;
    }
    
    public JButton getjButton4() {
        return jButton4;
    }
    public void refresh()
    {
        jLabel14.setText("");
        jLabel16.setText("");
        jLabel17.setIcon(new ImageIcon("questionmark.png"));
    }
}
