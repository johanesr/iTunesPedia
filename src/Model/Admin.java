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
    public boolean checkFields(String title, String artist, String album, String album_photo, String genre, int price)
    {
        if(title.equals("") || artist.equals("") ||  album.equals("") || album_photo.equals("") || genre.equals("") || price<=0)
        {
            return false;
        }
        return true;
    }
    public boolean addSong(String title, String artist, String album, String album_photo, String genre, int price) throws FileNotFoundException, SQLException, IOException
    {
        establishConnection();
        boolean a= checkFields(title, artist, album, album_photo, genre, price);
        if(a)
        {
            String query = "INSERT song_tbl(title, artist, album, album_photo, genre, popularity, price) values (?, ?, ?, ?, ?, ?, ?)";
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
}
