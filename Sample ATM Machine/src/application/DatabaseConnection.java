package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DatabaseConnection {
	protected final String driver = "com.mysql.jdbc.Driver";
	protected final String database = "jdbc:mysql://localhost/usecuredb";
	protected final String username = "root";
	protected final String password = "sa";
	
	private static int id;
	public static int getID () {
		return id;
	}
	public int loginPinNumber (String pin_number) throws Exception, SQLException {
		Connection con = null;
        Statement stm = null;
        try {
            Class.forName (driver);
            con = DriverManager.getConnection(database, username, password);
            stm = con.createStatement();
            String sql = "select * from pin_number_table";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
            	if (rs.getString("number").equals(pin_number)) {
            		return rs.getInt("id");
            	}
            }
            rs.close();
        } 
        finally {
            if (con != null)
                con.close();
        }
        return 0;
	}
	public boolean checkIfEnable (int id) throws Exception, SQLException {
		Connection con = null;
        Statement stm = null;
        try {
            Class.forName (driver);
            con = DriverManager.getConnection(database, username, password);
            stm = con.createStatement();
            String sql = "select * from enable_withdrawal_table where id='" + id + "'";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
            	if (rs.getString("enable").equals("true")) {
            		return true;
            	}
            }
            rs.close();
        } 
        finally {
            if (con != null)
                con.close();
        }
        return false;
	}
}
