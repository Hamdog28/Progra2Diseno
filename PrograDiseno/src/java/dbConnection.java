

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class dbConnection {
    private static final String conexion="jdbc:mysql://localhost/inconsistenciasactas?characterEncoding=UTF-8&useSSL=false";
    public static Connection conectDB(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con= DriverManager.getConnection(conexion,"root","lancelote1");
          return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    
        return null;
    }
     
        
      
}
