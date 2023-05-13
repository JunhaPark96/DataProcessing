package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import connection.JDBC;

public class CustomerImpl {
	private static Scanner scanner = new Scanner(System.in);
	private static JDBC jdbc = JDBC.getInstance();
	HashMap<Integer, Integer> mgrEmpno = new HashMap<>();
//	List<Integer> mgrEmpno = new ArrayList<>();
	
	public static void customerList() {
	    try {
	        Connection conn = jdbc.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select id, pwd, name, account_mgr from customer");
	        
	        while (rs.next()) {
	            int account_mgr = rs.getInt(4);
	            
	            if (mgrEmpno.containsKey(account_mgr)) {
	            	
	            }
	            
	            
//	            System.out.println(rs.getInt("account_mgr"));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // connection 종료 안함
	    }
	}
}
