package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.JDBC;
import repository.CustomerRepository;
import table.Customer;

public class CustomerImpl implements CustomerRepository{
	private static final Logger LOGGER = Logger.getLogger(CustomerImpl.class.getName());

	private static JDBC jdbc = JDBC.getInstance();
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	HashMap<Integer, Integer> mgrEmpno = new HashMap<>();
	private List<Customer> customerList = new ArrayList<>();
	
	@Override
	public List<Customer> printCustomerList() {
	    try {
	        Connection conn = jdbc.getConnection();
	        conn.setAutoCommit(false);
	        
	        String sql = "insert into bonus(ename, job, sal, comm)"
	        		+ "select e.ename, e.job, e.sal, case"
	        		+ "when e.job in ('PRESIDENT', 'ANALYST') then 0"
	        		+ "else nvl(c.comm, 0) + nvl(e.comm, 0) end as comm"
	        		+ "from emp e,"
	        		+ "(select account_mgr, case"
	        		+ "when count(account_mgr) < 100000 then 1000"
	        		+ "else 2000"
	        		+ "end as comm"
	        		+ "from customer group by account_mgr) c"
	        		+ "where e.empno = c.account_mgr(+);";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        conn.commit();
	        pstmt.close();
	        
	        
//	        Statement stmt = conn.createStatement();
//	        String sql = "{call incentive_10000}";
//	        CallableStatement cstmt = conn.prepareCall(sql);
//	        cstmt.execute();
//	        conn.commit();
//	        cstmt.close();
	        
//	        stmt.setFetchSize(1000);
	        // fetch size 10, 100, 1000, 10000 변경
//	        while (rs.next()) {
//	            int account_mgr = rs.getInt(4);
//	            
//	            // 사원번호를 키 값으로 value(횟수)를 증가 시킴
//	            if (mgrEmpno.containsKey(account_mgr)) {
//	            	int cnt = mgrEmpno.get(account_mgr) + 1;
//	            	mgrEmpno.put(account_mgr, cnt);
//	            // 첫 번째로 키 값을 찾은 경우	cnt 1회로 시작
//	            } else {
//	            	mgrEmpno.put(account_mgr, 1);
//	            }
//	        }
//	        for (Integer idx : mgrEmpno.keySet()) {
//	        	Customer customer = new Customer(idx, mgrEmpno.get(idx));
//	        	customerList.add(customer);
//	        }
//	        rs.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LOGGER.log(Level.SEVERE, "An error occurred while executing the query", e);
	    } finally {
	    	try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("Preparedstatement 종료 실패: " + e.getMessage());
				LOGGER.log(Level.WARNING, "Failed to close Preparedstatement", e);
			}
	    }
	    return customerList;
	}
}
