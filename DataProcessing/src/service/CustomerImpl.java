package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import connection.JDBC;
import repository.CustomerRepository;
import table.Customer;

public class CustomerImpl implements CustomerRepository{
	private static JDBC jdbc = JDBC.getInstance();
	Connection conn = null;
	Statement stmt = null;
	
	HashMap<Integer, Integer> mgrEmpno = new HashMap<>();
	private List<Customer> customerList = new ArrayList<>();
	
	@Override
	public List<Customer> printCustomerList() {
	    try {
	        Connection conn = jdbc.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select id, pwd, name, account_mgr from customer");
	        
	        while (rs.next()) {
	            int account_mgr = rs.getInt(4);
	            
	            // 사원번호를 키 값으로 value(횟수)를 증가 시킴
	            if (mgrEmpno.containsKey(account_mgr)) {
	            	int cnt = mgrEmpno.get(account_mgr) + 1;
	            	mgrEmpno.put(account_mgr, cnt);
	            // 첫 번째로 키 값을 찾은 경우	cnt 1회로 시작
	            } else {
	            	mgrEmpno.put(account_mgr, 1);
	            }
	        }
	        for (Integer idx : mgrEmpno.keySet()) {
	        	Customer customer = new Customer(idx, mgrEmpno.get(idx));
	        }
	        rs.close();
	        stmt.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("statement 종료 실패: " + e.getMessage());
			}
	    }
	    return customerList;
	}
}
