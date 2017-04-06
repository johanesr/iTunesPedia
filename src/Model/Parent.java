package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parent 
{
    private int choose;
    private Connection conn = null;
    private Statement st = null;

    public Parent(){}
    public void establishConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","");
            st = conn.createStatement();
            if(!conn.isValid(5))
            {
                System.out.println("Connection Error");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } 
    }
    public Boolean validateLogin(String username, String password, int choose)
    {
        establishConnection();
        try 
        {
            if(choose == 0)
            {
                ResultSet rs = st.executeQuery("SELECT * FROM user WHERE username='"+ username +"'");
                if(rs.next())
                {
                    System.out.println("user : " + rs.getString("username"));
                    System.out.println("Password : " + rs.getString("password"));
                    System.out.println("my password " + password);
                    if(rs.getString("Password").equals(password))
                    {
                        return true;
                    }
                }
                else
                {   
                    return false;
                }
            }
            else
            {
                ResultSet rs = st.executeQuery("SELECT * FROM admin WHERE Username='"+ username +"'");
                if(rs.next())
                {
                    if(rs.getString("Password").equals(password))
                    {
                        return true;
                    }
                }
                else
                {
                    return false;
                }
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: " + ex);
        }
        return false;
    }
}
