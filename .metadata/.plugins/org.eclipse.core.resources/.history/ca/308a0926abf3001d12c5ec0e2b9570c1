package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.JDBC;
import repository.EmpRepository;
import table.Customer;
import table.Emp;

public class EmpImpl implements EmpRepository{
	private JDBC jdbc = JDBC.getInstance();
	Connection conn = null;
	Statement stmt = null;
	
	List<Emp> empList = new ArrayList<>();
	
	@Override
	public List<Emp> bonusLogic(List<Customer> customerList) {
	    try {
	        Connection conn = jdbc.getConnection(); // jdbc연결 가져오기
	        Statement stmt = conn.createStatement();
	        
	        for (Customer customer : customerList) {
	        	// customer 테이블의 empno과 일치 하는 사원 select
	        	int c_empno = customer.getAccountMgr();
//	        	System.out.println(c_empno); // 오류 확인 출력 찍기
	        	ResultSet rs = stmt.executeQuery("select * from emp where empno = " + c_empno);
	        	
	        	while (rs.next()) {
	        		int empno = rs.getInt(1);
	        		String ename = rs.getString(2);
	        		String job = rs.getString(3);
	        		int mgr = rs.getInt(4);
	        		int sal = rs.getInt(6);
	        		int comm = rs.getInt(7);
	        		int deptno = rs.getInt(8);
//	        		System.out.println(
//	        				rs.getInt("empno") + " " + rs.getString("ename") + " " + rs.getString("job")
//	        				+ " " + rs.getInt("mgr") + " " + rs.getString("hireDate")
//	        				+ " " + rs.getInt("sal") + " " + rs.getInt("comm") +
//	        				" " + rs.getInt("deptno"));
	        		// president와 analyst 보너스 제외
	        		if (job.equals("PRESIDENT") || job.equals("ANALYST")) {
	        			Emp emp = new Emp(empno, ename, job, mgr, sal, comm, deptno);
	        			empList.add(emp);
	        		} else { // 10만 이상인 경우 보너스 2000
	        			if (customer.getCount() >= 100000) {
	        				Emp emp = new Emp(empno, ename, job, mgr, sal, comm + 2000, deptno);
	        				empList.add(emp);
	        			} else { // 10만 이하인 경우 보너스 1000
	        				Emp emp = new Emp(empno, ename, job, mgr, sal, comm + 1000, deptno);
	        				empList.add(emp);
	        			}
	        		}
	        	}
	        	rs.close();
	        }
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
	    return empList;
	}
}
