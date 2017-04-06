package View;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class LogInView extends javax.swing.JFrame 
{
    public LogInView() {
        initComponents();
        setTitle("Login");
        setLocationRelativeTo(null);
        
        jLabel1.setIcon(new ImageIcon("background.jpg"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        signupBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        forgetPassBtn = new javax.swing.JButton();
        errorLbl = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 190, 110, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 230, 110, 22);
        jPanel1.add(passTxt);
        passTxt.setBounds(440, 230, 173, 22);

        loginBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginBtn.setText("Log In");
        jPanel1.add(loginBtn);
        loginBtn.setBounds(300, 310, 90, 30);

        signupBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupBtn.setText("Sign Up");
        jPanel1.add(signupBtn);
        signupBtn.setBounds(297, 430, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Don't have an account yet?");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 380, 290, 22);

        forgetPassBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forgetPassBtn.setText("Forget Password?");
        jPanel1.add(forgetPassBtn);
        forgetPassBtn.setBounds(410, 430, 160, 30);

        errorLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errorLbl.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(errorLbl);
        errorLbl.setBounds(440, 310, 250, 60);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(440, 190, 173, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(440, 270, 63, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Sign In as");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(300, 270, 110, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Log In");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 60, 200, 90);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -60, 930, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void setActionListenerLoginBtn(ActionListener a){
        loginBtn.addActionListener(a);
    }
    public void setActionListenerSignupBtn(ActionListener a){
        signupBtn.addActionListener(a);
    }
    public void setActionListenerForgetPassword(ActionListener a){
        forgetPassBtn.addActionListener(a);
    }
    public String getUsername(){
        return jTextField2.getText();
    }
    public String getPassword(){
        return passTxt.getText();
    }
    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }
    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }
    public void setErrorTextRight(){
        errorLbl.setText("Welcome");
    }
    public void setErrorTextWrong(){
        errorLbl.setText("Invalid username or password");
        Component frame = null;
        jOptionPane1.showMessageDialog(frame, "Invalid username or password");
        refresh();
    }
    public void refresh(){
        jTextField2.setText("");
        passTxt.setText("");
        errorLbl.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton forgetPassBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JButton signupBtn;
    // End of variables declaration//GEN-END:variables
}
