package koneksi;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conn {
    Connection conn;
    public static Connection BukaConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kristian_2110010557","root","");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e);
            return null;
        }
    }
    
}
