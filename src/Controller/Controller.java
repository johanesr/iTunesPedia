package Controller;

import Model.Admin;
import View.LogInView;
import Model.Parent;
import Model.Songs;
import Model.Table;
import Model.User;
import View.AdminHomePage;
import View.ForgetPassword;
import View.Reset;
import View.SignUpView;
import View.TopUp;
import View.UserHomePage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Controller 
{
    private LogInView loginV = new LogInView();
    private Parent parentM = new Parent();
    private SignUpView signupV = new SignUpView();
    private User userM = new User();
    private Admin adminM = new Admin();
    private UserHomePage hpu = new UserHomePage();
    private AdminHomePage hpa = new AdminHomePage();
    private ForgetPassword fp = new ForgetPassword();
    private TopUp topUp = new TopUp();
    private Reset reset = new Reset();
    private String randomNumbers = "";
    
    private Connection conn = null;
    private Statement st = null;
 
    public void start()
    {
        setActionListeners();
        loginV.setVisible(true);
    }
    public String getRandNumbers()
    {
        String randNumbers = "";
        for(int i=0;i<5;i++)
        {
            int random = (int)(Math.random()*10);
            randNumbers += Integer.toString(random);
        }
        return randNumbers;
    }
    public String saveRandNum(String a)
    {
        this.randomNumbers = a;
        return a;
    }
    public void populateTable()
    {
        ArrayList<Songs> list = userM.BindTable();
        String[] columnName = {"Title","Artist","Album","Album Photo","Genre","Popularity","Price"};
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++)
        {
            rows[i][0] = list.get(i).getTitle();
            rows[i][1] = list.get(i).getArtist();
            rows[i][2] = list.get(i).getAlbum();
            rows[i][4] = list.get(i).getGenre();
            rows[i][5] = list.get(i).getPopularity();
            rows[i][6] = list.get(i).getPrice();
            
            if(list.get(i).getImage() != null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon
                (list.get(i).getImage()).getImage().getScaledInstance(176, 176, Image.SCALE_SMOOTH));   
                rows[i][3] = image;
            }
            else
            {
                rows[i][3] = null;
            }
            Table model = new Table(rows, columnName);
            hpu.getjTable1().setModel(model);
            hpu.getjTable1().setRowHeight(176);
            hpu.getjTable1().getColumnModel().getColumn(3).setPreferredWidth(50);
        }
    }
      public void populateTable2()
    {
        String username = loginV.getUsername();
        ArrayList<Songs> list = userM.BindTable2(username);
        String[] columnName = {"Title","Artist","Album","Album Photo","Genre","Popularity","Price"};
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++)
        {
            rows[i][0] = list.get(i).getTitle();
            rows[i][1] = list.get(i).getArtist();
            rows[i][2] = list.get(i).getAlbum();
            rows[i][4] = list.get(i).getGenre();
            rows[i][5] = list.get(i).getPopularity();
            rows[i][6] = list.get(i).getPrice();
            
            if(list.get(i).getImage() != null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon
               (list.get(i).getImage()).getImage().getScaledInstance(176, 176, Image.SCALE_SMOOTH));   
               rows[i][3] = image;
            }
            else
            {
                rows[i][3] = null;
            }
            Table model = new Table(rows, columnName);
            hpu.getjTable2().setModel(model);
            hpu.getjTable2().setRowHeight(176);
            hpu.getjTable2().getColumnModel().getColumn(3).setPreferredWidth(50);
        }
    }
    public int validateTopUpFields(String CCNo, String secCode, String name, int month, int year, int amount)
    {
        Calendar now = Calendar.getInstance();
        int currMonth = now.get(Calendar.MONTH)  +1 ;  
        int currYear = now.get(Calendar.YEAR);
        if(CCNo.equals("") || secCode.equals("") || name.equals(""))
        {
            return 1;
        }
        else if(CCNo.length()!= 12)
        {
            return 1;
        }
        else if(secCode.length() != 3)
        {
            return 1;
        }
        else if(currYear > year)
        {
            return 1;
        }
        else if(currYear == year)
        {
            if(currMonth > month)
            {
                return 1;
            }
        }
        else if(amount < 20000)
        {
            return 2;
        }
        System.out.println(amount);

        return 0;
    }
    public void setActionListeners()
    {
        loginV.setActionListenerLoginBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = loginV.getUsername();
                String password = loginV.getPassword();
                int choose = loginV.getjComboBox1().getSelectedIndex();
                Boolean vl = parentM.validateLogin(username, password, choose);
                
                if(vl && choose == 0)
                {
                    hpu.setVisible(true);
                    hpu.setUsername(loginV.getUsername());
                    hpu.setBalance(userM.getBalance(loginV.getUsername()));
                    populateTable();
                    populateTable2();
                    loginV.setVisible(false);
                    loginV.dispose();
                }
                else if (vl && choose == 1)
                {
                    hpa.setVisible(true);
                    loginV.dispose();
                    loginV = new LogInView();
                    setActionListeners();
                }
                else
                {
                    loginV.setErrorTextWrong();
                }
            }
        });
        loginV.setActionListenerSignupBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                signupV.setVisible(true);
                loginV.dispose();
                loginV = new LogInView();
                setActionListeners();
            }
        });
        loginV.setActionListenerForgetPassword(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                fp.setVisible(true);
                loginV.dispose();
                loginV = new LogInView();
                setActionListeners();
            }
        });
        signupV.setActionListenerSignUpBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = signupV.getUsername();
                String password = signupV.getPassword();
                String password2 = signupV.getRePassword();
                String email = signupV.getEmail();
                Boolean a = userM.insertDatabase(username, password, password2, email);

                if(a)
                {
                    signupV.setErrorTextRight("Sign Up successful!!");
                    loginV.setVisible(true);
                    
                    signupV.dispose();
                    signupV = new SignUpView();
                    setActionListeners();
                }
                else if(!userM.validateUsername(username))
                {
                    signupV.setErrorTextRight("Username already exist!! Try again!");
                }
                else if(!userM.validatePassword(password, password2))
                {
                    signupV.setErrorTextRight("Passwords does not match!! Try Again!");
                }
                else if(!userM.validateFields(username, password, email))
                {
                    signupV.setErrorTextRight("All Fields must be filled!! Try Again!");
                }

            }
        });
        signupV.setActionListenerBackBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                loginV.setVisible(true);
                signupV.dispose();
                signupV = new SignUpView();
                setActionListeners();
            }
        });
        hpu.setActionListenerPurchaseBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String title = hpu.getjLabel8().getText();
                String artist = hpu.getjLabel9().getText();
                String album = hpu.getjLabel10().getText();
                String username = loginV.getUsername();
                
                if(userM.insertSongList(title, artist, album, username))
                {
                    hpu.setjLabel14("Purchase Successful");
                }    
                else
                {
                    hpu.setjLabel14("Song already purchased!! ");
                }
                populateTable();
                populateTable2();
                hpu.setBalance(userM.getBalance(loginV.getUsername()));
            }
        });
        fp.setActionListenerSendEmail(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String email = fp.getEmail();
                String randNum = getRandNumbers();
                if(!userM.sendVerificationCode(email, randNum))
                {
                    fp.setErrorEmail("Invalid Email!! Try Again!");
                }
                else
                {
                    String a = saveRandNum(randNum);
                }
	}});
        fp.setActionListenerVerify(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String a = "";
                a +=saveRandNum(randomNumbers);
                String code = fp.getCode();
                if(code.equals(a) && !code.equals(""))
                {
                    System.out.println("verified");
                    reset.setVisible(true);
                    fp.dispose();
                    fp = new ForgetPassword();
                    setActionListeners();
                }
                else
                {
                    fp.setErrorWrongCode("Wrong Verification Code!! Try Again!");
                }
            }
        });
        reset.setActionListenerResetPassword(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String password = reset.getPassword();
                String password2 = reset.getRePassword();
                String email = fp.getEmail();
                if(userM.resetPassword(password, password2, email))
                {
                    reset.setSuccessMessage("Reset Password Successful!! ");
                }
                else
                {
                    reset.setError("Passwords does not match!! ");
                }
            }
        });
        hpa.setActionListenerBrowse(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser chooser = new JFileChooser();
                FileReader in = null;
                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile = chooser.getSelectedFile();
                    try 
                    {
                        in = new FileReader(selectedFile);
                        String filename = selectedFile.getAbsolutePath();
                        System.out.println(filename);
                        hpa.setFileName(filename);
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File Not Found");
                    }    
                }
            }
        });
        hpa.setActionListenerAdd(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String title = hpa.getTitle();
                    String artist = hpa.getArtist();
                    String album  = hpa.getAlbum();
                    String album_photo = hpa.getAlbumPhoto();
                    String genre = hpa.getGenre();
                    int price = hpa.getPrice();
                    
                    if(adminM.addSong(title, artist, album, album_photo, genre, price))
                    {
                        
                        hpa.setSuccessMessage("Song succesfully added!!");
                        System.out.println("success");
                    }
                    else if(!adminM.checkFields(title, artist, album, album_photo, genre, price))
                    {
                        
                        hpa.setErrorMessage("All fields must be filled!! ");
                        System.out.println("error");
                    }
                } 
                catch (SQLException | IOException ex) 
                {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        hpu.setActionListenerTopUp(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                topUp.setVisible(true);
            }
        });
        topUp.setActionListenertopUp(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = loginV.getUsername();
                String CCNo = topUp.getCCNo();
                String SecCode = topUp.getSecCode();
                String name = topUp.getNameonCard();
                int expMonth = topUp.getExpiryMonth() + 1;
                int expYear = topUp.getExpiryYear();
                int amount = topUp.getAmount();
                int result=0;
                result = validateTopUpFields(CCNo,SecCode, name, expMonth, expYear, amount);
                if(result == 0)
                {
                    System.out.println("top up successful");
                    userM.addBalance(username, amount);
                    topUp.dispose();
                    topUp = new TopUp();
                    setActionListeners();
                    hpu.setBalance(userM.getBalance(loginV.getUsername()));
                }
                else if(result == 1)
                {
                    topUp.setErrorText("Invalid credit card!! Try Again");
                }
                else 
                {
                    topUp.setErrorText("Minimum top up is Rp. 20 000");
                }
            }
        });
    }
}
