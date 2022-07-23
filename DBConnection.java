
package Emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    private static Connection conn;
    static
    {
       try
       {
         Class.forName("oracle.jdbc.OracleDriver");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-VKCHFDD:1521/xe","grocery","grocery");
          // JOptionPane.showMessageDialog(null,"Connection opened Succesfully","Success",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(ClassNotFoundException ex)
       {
            JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
       }
       catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"Error is opening Connection","DB Error!",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
    }
    public static Connection getConnection()
    {
       return conn ;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
              JOptionPane.showMessageDialog(null,"connection has been closed successfully","connection closed",JOptionPane.INFORMATION_MESSAGE);
            
        }
         catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"Error is opening Connection","DB Error!",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
    }
}
