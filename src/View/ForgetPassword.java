package View;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ForgetPassword extends javax.swing.JFrame 
{
    public ForgetPassword() 
    {
        initComponents();
        setTitle("Forget Password");
        setLocationRelativeTo(null);
        jLabel1.setIcon(new ImageIcon("background2.jpg"));
    }
    @SuppressWarnings("unchecked")
    public void setErrorWrongCode(String error)
    {
        jLabel4.setText(error);
    }
    public void setErrorEmail(String error)
    {
        jLabel5.setText(error);
    }
    public void setActionListenerSendEmail(ActionListener a) {
        jButton1.addActionListener(a);
    }
    public void setActionListenerVerify(ActionListener a) {
        jButton2.addActionListener(a);
    }
    public void setActionListenerBackBtn(ActionListener a)
    {
        BackBtn.addActionListener(a);
    }
    public String getEmail() {
        return jTextField1.getText();
    }  
    public String getCode() {
        return jTextField2.getText();
    }

    public JButton getjButton1() {
        return jButton1;
    }
    public void refresh()
    {
        jLabel4.setText("");
        jLabel5.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jButton1.setVisible(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 130, 60, 30);

        jTextField1.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 170, 349, 47);

        jButton1.setText("Send Verification Code");
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 230, 349, 39);

        jTextField2.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(100, 350, 349, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 310, 70, 30);

        jButton2.setText("Verify");
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 420, 349, 36);

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 465, 219, 21);

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(162, 294, 203, 14);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Forgot Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 30, 210, 70);

        BackBtn.setText("Back");
        getContentPane().add(BackBtn);
        BackBtn.setBounds(100, 510, 70, 30);

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -20, 980, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
