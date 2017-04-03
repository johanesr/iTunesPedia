package Model;

import Controller.Controller;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

public class User 
{
    private Connection conn = null;
    private Statement st = null;
    
    public void establishConnection()
    {
        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject","root","");
            st = conn.createStatement();
            if(!conn.isValid(5))
            {
                System.out.println("Connection Error");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: " + ex);
        } 
    }
    public Boolean validatePassword(String password, String password2)
    {   
        if(!password.equals(password2))
        {
            return false;
        }
        return true;
    }
    public Boolean validateFields(String username, String password, String email)
    {
        if(username.equals("") || password.equals("") || email.equals(""))
        {
            return false;
        }
        return true;
    }   
    public Boolean validateUsername(String username)
    {
        this.establishConnection();
        try 
        {
            String query ="SELECT * FROM User WHERE Username='" + username + "'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                return false;
            }
            else
            {
                return true;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
            return true;
        }
    }
    public Boolean insertDatabase(String username, String password, String password2, String email)
    {
        Boolean a = validateUsername(username);
        Boolean b = validatePassword(password, password2);
        Boolean c = validateFields(username, password, email);
        
        if(a && b && c )
        {
            try 
            {
                String query = "INSERT INTO user (`username`,`password`,`email`, `balance`) VALUE ('"+ username + "','" + password + "','" + email + "','" + 100000 + "')";
                int rs1 = st.executeUpdate(query);
                return true;
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    public ArrayList<Songs> BindTable()
    {
        this.establishConnection();
        ArrayList<Songs> list = new ArrayList<Songs>();
        try 
        {
            ResultSet rs = st.executeQuery("SELECT `title`,`artist`,`album`,`album_photo`,`genre`,`popularity`,`price` FROM `song_tbl`");

            Songs p;
            while(rs.next())
            {
                p = new Songs(
                rs.getString("title"),
                rs.getString("artist"),
                rs.getString("album"),
                rs.getBytes("album_photo"),
                rs.getString("genre"),
                rs.getInt("popularity"),
                rs.getInt("price")
                );
                list.add(p);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public ArrayList<Songs> BindTable2(String username)
    {
        this.establishConnection();
        ArrayList<Songs> list = new ArrayList<>();
        try 
        {
            ArrayList <Integer> alist = new ArrayList<>();
            String song_list_query = null;
            String query2 ="SELECT * FROM user WHERE username='" + username + "'";
            ResultSet rs = st.executeQuery(query2);
            int user_ID = 0;
            if (rs.next())
            {
                user_ID = rs.getInt("user_ID");
            }
            rs= st.executeQuery("SELECT * FROM `song_list` WHERE user_ID='" + user_ID + "'");

            while(rs.next())
            {
                alist.add(rs.getInt("song_ID"));
            }                  
            if(alist.size() > 0)
            {
                song_list_query = "SELECT `title`,`artist`,`album`,`album_photo`,`genre`,`popularity`,`price` FROM `song_tbl` WHERE song_ID='" + alist.get(0) + "'";
                if(alist.size() >1)
                {
                    for(int i=1;i<alist.size();i++)
                    {
                        song_list_query += " OR song_ID='" + alist.get(i) + "'";
                    }
                }
                rs = st.executeQuery(song_list_query);
            }
            else
            {
                System.out.println("eeror2");
            }
            Songs p;
            while(rs.next())
            {
                p = new Songs(
                rs.getString("title"),
                rs.getString("artist"),
                rs.getString("album"),
                rs.getBytes("album_photo"),
                rs.getString("genre"),
                rs.getInt("popularity"),
                rs.getInt("price")
                );
                list.add(p);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean insertSongList(String title, String artist, String album, String username)
    {
        this.establishConnection();
        try 
        {
            System.out.println("1");
            String query ="SELECT * FROM song_tbl WHERE title='" + title + "' AND artist='" + artist + "' AND album='" + album + "'";
            ResultSet rs = st.executeQuery(query);
            int song_ID=0;
            int balance=0;
            int popularity =0;
            int price=0;
            if (rs.next())
            {
                song_ID = rs.getInt("song_ID");
                popularity = rs.getInt("popularity");
                price = rs.getInt("price");
            }
            
            System.out.println("2");
            String query2 ="SELECT * FROM User WHERE username='" + username + "'";
            rs = st.executeQuery(query2);
            int user_ID = 0;
            if (rs.next())
            {
                user_ID = rs.getInt("user_ID");
                balance = rs.getInt("balance");
            }
            
            
            System.out.println("3");
            String query3 = "SELECT * FROM song_list WHERE user_ID='" + user_ID + "' AND song_ID='" + song_ID + "'";
            rs = st.executeQuery(query3);
            if(!rs.next())
            {    
                
                String query4 = "INSERT INTO song_list(`user_ID`,`song_ID`) VALUE ('"+ user_ID + "','" + song_ID  + "')";
                int rs1 = st.executeUpdate(query4);
                popularity++;
                String query5 = "UPDATE song_tbl SET popularity='" + popularity + "' WHERE title='" + title + "' AND artist='" + artist + "' AND album='" + album + "'";
                int rs2 = st.executeUpdate(query5);
                balance = balance - price;
                String query6 = "UPDATE user SET balance='" + balance + "' WHERE username='" + username + "'";
                int rs3 = st.executeUpdate(query6);
                System.out.println("sadhfajdsfhdasfadsfjasdfijdsaf");
                
                return true;
            }
            else
            {
                System.out.println("Song already purchased!!");
                return false;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);

        }
        return true;
        
    }
    public boolean sendVerificationCode(String email, String randNumbers)
    {
        establishConnection();
        final String username = "jkctunespedia@gmail.com";
	final String password = "jkctunespedia123";
                
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	Session session = Session.getInstance(
        props, new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
		return new PasswordAuthentication(username, password);
            }
        });          
        try 
        {
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE email='"+ email +"'");
            if(rs.next())
            {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
                       
                System.out.println(randNumbers);
                message.setSubject("Verification Code");
                message.setText("Dear "+ rs.getString("username") + ","+ "\n\nYour TunesPedia Verification Code is : " + randNumbers);
                            
                Transport.send(message);

		System.out.println("Done");
                randNumbers="";
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (AddressException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (MessagingException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean sendSignUpCode(String email, String randNumbers)
    {
        establishConnection();
        final String username = "jkctunespedia@gmail.com";
	final String password = "jkctunespedia123";
                
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	Session session = Session.getInstance(
        props, new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
		return new PasswordAuthentication(username, password);
            }
        });
        try 
        {
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE email='"+ email +"'");
            if(rs.next())
            {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                       
                System.out.println(randNumbers);
                message.setSubject("Verification Code");
                message.setText("Dear "+ rs.getString("username") + ","+ "\n\nYour TunesPedia Sign Up Verification Code is : " + randNumbers);
                            
                Transport.send(message);

		System.out.println("Done");
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (AddressException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (MessagingException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean resetPassword(String password, String password2, String email)
    {
        if(validatePassword(password, password2))
        {
            try 
            {
                String query = "UPDATE user SET password='" + password + "' WHERE email='" + email + "'";
                int rs1 = st.executeUpdate(query);
                return true;
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        else
        {
            return false;
        }
        return true;
    }
    public int getBalance(String username)
    {
        int balance =0;
        establishConnection();
        try 
        {
            ResultSet rs= st.executeQuery("SELECT * FROM `user` WHERE username='" + username+ "'");
            if(rs.next())
            {
                balance = rs.getInt("balance");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    public void addBalance(String username, int amount)
    {
        int balance=0;
        establishConnection();
        try 
        {
            String query ="SELECT * FROM User WHERE username='" + username + "'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                balance = rs.getInt("balance");
            }
            balance += amount;
            String query2 = "UPDATE user SET balance='" + balance + "' WHERE username='" + username + "'";
            int rs2 = st.executeUpdate(query2);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
