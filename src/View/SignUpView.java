package View;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class SignUpView extends javax.swing.JFrame 
{
    public SignUpView() 
    {
        initComponents();
        setTitle("Sign Up");
        setLocationRelativeTo(null);
        
        jLabel1.setIcon(new ImageIcon("background3.jpg"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        su = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        passTxt2 = new javax.swing.JPasswordField();
        emailTxt = new javax.swing.JTextField();
        SignUpBtn = new javax.swing.JButton();
        errorLbl = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        su.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        su.setForeground(new java.awt.Color(255, 255, 255));
        su.setText("Sign Up");
        jPanel1.add(su);
        su.setBounds(12, 19, 102, 46);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password                    : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 220, 150, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Re-type Password    : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 260, 150, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email                           :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 296, 170, 20);
        jPanel1.add(usernameTxt);
        usernameTxt.setBounds(250, 170, 140, 30);
        jPanel1.add(passTxt);
        passTxt.setBounds(250, 210, 140, 30);
        jPanel1.add(passTxt2);
        passTxt2.setBounds(250, 250, 140, 30);
        jPanel1.add(emailTxt);
        emailTxt.setBounds(250, 290, 140, 30);

        SignUpBtn.setText("SignUp");
        jPanel1.add(SignUpBtn);
        SignUpBtn.setBounds(190, 380, 80, 30);

        errorLbl.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorLbl);
        errorLbl.setBounds(250, 330, 280, 30);

        BackBtn.setText("Back");
        jPanel1.add(BackBtn);
        BackBtn.setBounds(300, 380, 70, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username               : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 180, 127, 16);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 680, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setActionListenerSignUpBtn(ActionListener a)
    {
        SignUpBtn.addActionListener(a);
    }
    public void setActionListenerBackBtn(ActionListener a)
    {
        BackBtn.addActionListener(a);
    }

    public String getUsername()
    {
        return usernameTxt.getText();
    }
    public String getPassword()
    {
        return passTxt.getText();
    }
    public String getRePassword()
    {
        return passTxt2.getText();
    }
    public String getEmail()
    {
        return emailTxt.getText();
    }
    public void setErrorTextRight(String error)
    {
        errorLbl.setText(error);
    }

    public void refresh()
    {
        usernameTxt.setText("");
        passTxt.setText("");
        passTxt2.setText("");
        emailTxt.setText("");
        errorLbl.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPasswordField passTxt2;
    private javax.swing.JLabel su;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
