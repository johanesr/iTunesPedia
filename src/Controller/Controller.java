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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Controller extends JFrame
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
    private Songs songM = new Songs();
    
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
        ArrayList<Songs> list = userM.BindTable(); // store songs into the arraylist
        String[] columnName = {"Title","Artist","Album","Album Photo","Genre","Popularity","Price"}; // array type of string
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++)
        {
            rows[i][0] = list.get(i).getTitle(); // display each atribute accordingly
            rows[i][1] = list.get(i).getArtist();
            rows[i][2] = list.get(i).getAlbum();
            rows[i][4] = list.get(i).getGenre();
            rows[i][5] = list.get(i).getPopularity();
            rows[i][6] = list.get(i).getPrice();
            
            if(list.get(i).getImage() != null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon
                (list.get(i).getImage()).getImage().getScaledInstance(176, 176, Image.SCALE_SMOOTH));   
                rows[i][3] = image; // to display the image in the table
            }
            else
            {
                rows[i][3] = null;
            }
            Table model = new Table(rows, columnName);
            hpu.getjTable1().setModel(model);
            hpu.getjTable1().setRowHeight(176);//set row height for the image
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
    public void populateTable3(String text)
    {
        ArrayList<Songs> list = userM.search(text);
        String[] columnName = {"Title","Artist","Album","Album Photo","Genre","Popularity","Price"};
        Object[][] rows = new Object[list.size()][7];
            System.out.println(list.size());
            if(list.size() == 0)
            {
                hpu.getjTable1().setVisible(false);
            }
            else
            {
                hpu.getjTable1().setVisible(true);
            }
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
    public void populateTable4()
    {
        ArrayList<Songs> list = adminM.BindTable();
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
            hpa.getTable().setModel(model);
            hpa.getTable().setRowHeight(176);
            hpa.getTable().getColumnModel().getColumn(3).setPreferredWidth(50);
        }
    }
    public void populateTable5(String text)
    {
        ArrayList<Songs> list = adminM.search(text);
        String[] columnName = {"Title","Artist","Album","Album Photo","Genre","Popularity","Price"};
        Object[][] rows = new Object[list.size()][7];
            System.out.println(list.size());
            if(list.size() == 0)
            {
                hpa.getTable().setVisible(false);
            }
            else
            {
                hpa.getTable().setVisible(true);
            }
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
                hpa.getTable().setModel(model);
                hpa.getTable().setRowHeight(176);
                hpa.getTable().getColumnModel().getColumn(3).setPreferredWidth(50);
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
                    hpu.refresh();
                    hpu.setVisible(true);
                    hpu.setUsername(loginV.getUsername());
                    hpu.setBalance(userM.getBalance(loginV.getUsername()));
                    populateTable();
                    populateTable2();
                    loginV.setVisible(false);
                    hpu.getjButton4().setVisible(false);
                    setKeyListeners();
                }
                else if (vl && choose == 1)
                {
                    hpa.refresh();
                    hpa.setVisible(true);
                    populateTable4();
                    hpa.getjButton2().setVisible(true);
                    hpa.getjButton3().setVisible(false);
                    setMouseListeners();
                    setKeyListeners();
                    loginV.setVisible(false);
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
                signupV.refresh();
                signupV.setVisible(true);
                loginV.setVisible(false);
            }
        });
        loginV.setActionListenerForgetPassword(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                fp.refresh();
                fp.setVisible(true);
                loginV.setVisible(false);
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
                    loginV.refresh();
                    loginV.setVisible(true);
                    signupV.setVisible(false);
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
                loginV.refresh();
                loginV.setVisible(true);
                signupV.setVisible(false);
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
                int result = userM.insertSongList(title, artist, album, username);
                if(result == 0)
                {
                    hpu.setjLabel14("Purchase Successful");
                }    
                else if(result == 2)
                {
                    hpu.setjLabel14("Song already purchased!! ");
                }
                else
                {
                    hpu.setjLabel14("Balance insufficient!! Please Top Up First!! ");
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
                          System.out.println("hello");
                          String a = saveRandNum(randNum);
                          fp.getjButton1().setVisible(false);
                      }
            } });
        
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
                    reset.refresh();
                   System.out.println("verified");
                   reset.setVisible(true);
                   fp.setVisible(false);
                  // fp.dispose();
                   //fp = new ForgetPassword();
                  // setActionListeners();
                }
                else
                {
                    fp.setErrorWrongCode("Wrong Verification Code!! Try Again!");
                }
            }
        });
        fp.setActionListenerBackBtn(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                loginV.refresh();
                loginV.setVisible(true);
                fp.setVisible(false);
               // fp = new ForgetPassword();
               // setActionListeners();
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
                    reset.setVisible(false);
                    loginV.refresh();
                    loginV.setVisible(true);
                }
                else
                {
                    reset.setError("Passwords does not match or missing ");
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
        hpa.setActionListenerClear(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hpa.refresh();
            }
        });
        hpa.setActionListenerAdd(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = hpa.getTitle();
                    String artist = hpa.getArtist();
                    String album  = hpa.getAlbum();
                    String album_photo = hpa.getAlbumPhoto();
                    String genre = hpa.getGenre();
                    int price = hpa.getPrice();
                    String filepath = hpa.getFilePath();
                    
                    if(adminM.addSong(title, artist, album, album_photo, genre, price, filepath))
                    {
                        hpa.setSuccessMessage("Song succesfully added!!");
                        System.out.println("success");
                        populateTable4();
                    }
                    else if(!adminM.checkFields(title, artist, album, album_photo, genre, price, filepath))
                    {
                        hpa.setErrorMessage("All fields must be filled!! ");
                        System.out.println("error");
                    }
                        
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                
            }
        });
        hpa.setActionListenerUpdate(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = hpa.getTitle();
                    String artist = hpa.getArtist();
                    String album = hpa.getAlbum();
                    String album_photo = hpa.getAlbumPhoto();
                    String genre = hpa.getGenre();
                    String filepath = hpa.getFilePath();
                    int price = hpa.getPrice();
                    int song_ID = Integer.parseInt(hpa.getjLabel12().getText());
                    if(adminM.updateSong(title, artist, album, album_photo, genre, price, filepath, song_ID))
                    {
                        hpa.setSuccessMessage("Record Updated");
                        populateTable4();
                    }
                    else
                    {
                        hpa.setErrorMessage("Update fail!! All fields except Filepath and Album photo must be filled!!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        hpa.setActionListenerSignOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hpa.setVisible(false);
                loginV.refresh();
                loginV.setVisible(true);
            }
        });
        hpu.setActionListenerTopUp(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topUp.refresh();
                topUp.setVisible(true);
            }
        });
       
        topUp.setActionListenertopUp(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    topUp.setVisible(false);
                   // topUp.dispose();
                    //topUp = new TopUp();
                   // setActionListeners();
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
        topUp.setActionListenerCancel(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                hpu.refresh();
                hpu.setVisible(true);
                topUp.setVisible(false);
                
            }
            
         });
        hpu.setActionListenerPlay(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = hpu.getjLabel8().getText();
                String artist = hpu.getjLabel9().getText();
                String album = hpu.getjLabel10().getText();
                String username = loginV.getUsername();
                if(userM.validatePlay(title, artist, album, username))
                {
                    String filepath = userM.getFilePath(title, artist);
                    try {
                        if(!songM.SoundClipTest(filepath))
                        {
                            hpu.getjButton1().setVisible(false);
                        }
                            
                        
                        hpu.getjButton4().setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    hpu.setError("Song not purchased!! Unable to play song! ");

                }
            }
        });
        hpu.setActionListenerStopAudio(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                songM.stop();
                hpu.getjButton4().setVisible(false);
                hpu.getjButton1().setVisible(true);
            }
        });
        hpu.setActionListenerSignOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // hpu.dispose();
                //hpu = new UserHomePage();
                hpu.setVisible(false);
                loginV.refresh();
                //loginV = new LogInView();
                loginV.setVisible(true);
               //setActionListeners();
                
            }
        });
        
    }
    
    
    
    public void setKeyListeners()
    {
        hpu.keyRelease(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}   
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                String text = hpu.getjTextField1().getText();
                populateTable3(text);
            }
        });
        hpa.keyRelease(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = hpa.getjTextField7().getText();
                populateTable5(text);
            }
        });
    }
    public void setMouseListeners()
    {
        hpa.mouseClick(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hpa.refresh();
                hpa.getjButton2().setVisible(false);
                hpa.getjButton3().setVisible(true);
                JTable table = hpa.getTable();
                String title = table.getValueAt(table.getSelectedRow(), 0).toString();

                String artist = table.getValueAt(table.getSelectedRow(), 1).toString();
                String album = table.getValueAt(table.getSelectedRow(), 2).toString();
                String genre = table.getValueAt(table.getSelectedRow(), 4).toString();
                
                Integer price = (Integer) table.getValueAt(table.getSelectedRow(), 6);
                ImageIcon icon = (ImageIcon) table.getValueAt(table.getSelectedRow(), 3);
                
                
                hpa.getjTextField1().setText(title);
                hpa.getjTextField2().setText(artist);
                hpa.getjTextField3().setText(album);
                hpa.getjTextField4().setText("");
                hpa.getjTextField5().setText(genre);
                hpa.getjSpinner1().setValue(price);
                
                hpa.getjLabel1().setIcon(icon);
                int id = adminM.getSongID(title, artist, album);
                String filepath = adminM.getfilepath(id);
                hpa.getjTextField6().setText(filepath);
                hpa.getjLabel12().setText(Integer.toString(id));
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
}
