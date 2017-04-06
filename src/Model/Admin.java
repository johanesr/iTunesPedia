package Model;

import Controller.Controller;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class Admin 
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
    public boolean checkFields(String title, String artist, String album, String album_photo, String genre, int price, String filepath)
    {
        if(title.equals("") || artist.equals("") ||  album.equals("") || album_photo.equals("") || genre.equals("") || price<=0 || filepath.equals(""))
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
            while(rs.next()){
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
    public boolean addSong(String title, String artist, String album, String album_photo, String genre, int price, String filepath) throws FileNotFoundException, SQLException, IOException
    {
        establishConnection();
        boolean a= checkFields(title, artist, album, album_photo, genre, price, filepath);
        if(a)
        {
            String query = "INSERT song_tbl(title, artist, album, album_photo, genre, popularity, price, audio_file) values (?, ?, ?, ?, ?, ?, ?, ?)";
            FileInputStream fis = null;
            PreparedStatement ps = null;
            try 
            {
                conn.setAutoCommit(false);
                File file = new File(album_photo);
                fis = new FileInputStream(file);
                ps = conn.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, artist);
                ps.setString(3, album);
                ps.setBinaryStream(4, fis, (int) file.length());
                ps.setString(5, genre);
                ps.setInt(6, 0);
                ps.setInt(7, price);
                ps.setString(8, filepath);
                ps.executeUpdate();
                conn.commit();
                  return true;                
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally 
             {
                ps.close();
                fis.close();
             }
            
        }
        
        return false;
    }
    public int getSongID(String title, String artist, String album)
    {
        int song_ID=0;
        try {
            String query ="SELECT * FROM song_tbl WHERE title='" + title + "' AND artist='" + artist + "' AND album='" + album + "'";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                song_ID = rs.getInt("song_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return song_ID;
    }
    public String getfilepath(int id)
    {
        String filepath=null;
        try {
            String query ="SELECT * FROM song_tbl WHERE song_ID='" + id + "'";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                filepath = rs.getString("audio_file");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filepath;
    }
    public boolean checkOtherFields(String title, String artist, String album, String genre, int price)
    {
        if(title.equals("") || artist.equals("") ||  album.equals("") || genre.equals("") || price<=0)
        {
            return false;
        }
        return true;
    }
    public boolean updateSong(String title, String artist, String album, String album_photo, String genre, int price, String filepath, int id) throws SQLException, IOException
    {
        establishConnection();
        if(!checkOtherFields(title, artist, album, genre, price))
        {
  
            return false;
        }
        else if(filepath.equals("") && !album_photo.equals(""))
        {
             System.out.println(filepath);
            String query = "UPDATE song_tbl SET title=? , artist=? , album=?, album_photo=?, genre=?, price=? WHERE song_ID='" + id + "'";
            FileInputStream fis = null;
            PreparedStatement ps = null;
            try 
            {
                conn.setAutoCommit(false);
                File file = new File(album_photo);
                fis = new FileInputStream(file);
                ps = conn.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, artist);
                ps.setString(3, album);
                ps.setBinaryStream(4, fis, (int) file.length());
                ps.setString(5, genre);
                ps.setInt(6, price);
                ps.executeUpdate();
                conn.commit();
                return true;                
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally 
             {
                ps.close();
                fis.close();
             }
        }
        else if(album_photo.equals("") && !filepath.equals(""))
        {
            String query = "UPDATE song_tbl SET title='" + title + "', artist='" + artist+  "', album='" + album + "', genre='" + genre + "', price='" + price + "', audio_file='" + filepath + "' WHERE song_ID='" + id + "'";
            int rs = st.executeUpdate(query);
            return true;
        }
        else if(album_photo.equals("") && filepath.equals(""))
        {
            String query = "UPDATE song_tbl SET title='" + title + "', artist='" + artist+  "', album='" + album + "', genre='" + genre + "', price='" + price + "' WHERE song_ID='" + id + "'";
            int rs= st.executeUpdate(query);
            return true;
        }
        else if(!album_photo.equals("") && !filepath.equals(""))
        {
            System.out.println(filepath);
            String query = "UPDATE song_tbl SET title=? , artist=? , album=?, album_photo=?, genre=?, price=?, audio_file=? WHERE song_ID='" + id + "'";
            FileInputStream fis = null;
            PreparedStatement ps = null;
            try 
            {
                conn.setAutoCommit(false);
                File file = new File(album_photo);
                fis = new FileInputStream(file);
                ps = conn.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, artist);
                ps.setString(3, album);
                ps.setBinaryStream(4, fis, (int) file.length());
                ps.setString(5, genre);
                ps.setInt(6, price);
                ps.setString(7, filepath);
                ps.executeUpdate();
                conn.commit();
                return true;                
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally 
             {
                ps.close();
                fis.close();
             }
        }
        return true;
    }
    public ArrayList<Songs> search(String text)
    {
        this.establishConnection();
        String query = "";
        ArrayList<Songs> list = new ArrayList<Songs>();
        try 
        {
            list.clear();
            query = "SELECT `title`,`artist`,`album`,`album_photo`,`genre`,`popularity`,`price` FROM `song_tbl` WHERE title LIKE '%" + text + "%' OR artist LIKE '%" + text + 
                            "%' OR genre LIKE '%" + text + "' OR album LIKE '%" + text + "%' ";
            ResultSet rs = st.executeQuery(query);
            
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
}
