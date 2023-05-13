package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import connection.JDBC;
import repository.EmpRepository;

public class EmpImpl implements EmpRepository{
	private JDBC jdbc = JDBC.getInstance();
	
	@Override
	public void bonusLogic() {
	    try {
	        Connection conn = jdbc.getConnection(); // jdbc연결 가져오기
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from emp");
	        System.out.println("");
	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String ename = rs.getString(2);
	            String job = rs.getString(3);
	            int mgr = rs.getInt(4);
	            Date hireDate = rs.getDate(5);
	            int sal = rs.getInt(6);
	            int comm = rs.getInt(7);
	            int deptno = rs.getInt(8);
	            System.out.println(
	                    rs.getInt("empno") + " " + rs.getString("ename") + " " + rs.getString("job")
	                            + " " + rs.getInt("mgr") + " " + rs.getString("hireDate")
	                            + " " + rs.getInt("sal") + " " + rs.getInt("comm") +
	                            " " + rs.getInt("deptno"));
	            // 10만명 기준으로 보너스 지급
	            // president와 Analyst는 보너스 미지급
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // connection 종료 안함
	    }

	}
}
