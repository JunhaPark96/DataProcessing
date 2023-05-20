package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.JDBC;
import repository.BonusRepository;
import repository.CustomerRepository;
import repository.EmpRepository;
import service.BonusImpl;
import service.CustomerImpl;
import service.EmpImpl;
import table.Customer;
import table.Emp;

public class MainController {
	private CustomerRepository customerRepository = new CustomerImpl();
	private EmpRepository empRepository = new EmpImpl();
	private BonusRepository bonusRepository = new BonusImpl();

	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<>();
	List<Emp> empList = new ArrayList<>();

	public MainController() {
//		Scanner scanner = new Scanner(System.in);
		JDBC jdbc = JDBC.getInstance();
		Statement statement = null;
		
		String sql = "insert into bonus (ename, job, sal, comm)\r\n"
				+ "select e.ename, e.job, e.sal, case\r\n"
				+ "when e.job in ('ANALYST', 'PRESIDENT') then 0\r\n"
				+ "else nvl(c.comm, 0) + nvl(e.comm, 0) end as comm\r\n"
				+ "from emp e,\r\n"
				+ "(select account_mgr, case\r\n"
				+ "    when count(account_mgr) < 100000 then 1000\r\n"
				+ "    else 2000\r\n"
				+ "    end as comm\r\n"
				+ "    from customer group by account_mgr) c\r\n"
				+ "where e.empno = c.account_mgr(+)";
		long startTime = System.currentTimeMillis(); // 코드 실행 전 시간 측정
		try {
			System.out.println("Connected to database.");


			Connection conn = jdbc.getConnection();
			conn.setAutoCommit(false);
			// 데이터베이스 연결
			statement = conn.createStatement();
			statement.executeUpdate(sql);

			// 트랜잭션 커밋
			conn.commit();

			long endTime = System.currentTimeMillis(); // 코드 실행 후 시간 측정
			double time = (endTime - startTime) / 1000.0;
			System.out.println("처리시간 : " + time + "초");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void loadCustomerList() {
		long startTime = System.currentTimeMillis(); // 코드 실행 전 시간 측정

		// customerImpl에서 실행해온 결과를 List에 담기
		customerList = customerRepository.printCustomerList();

		// 사원 당 몇명의 고객을 담당하는지 출력
//		for (Customer customer : customerList) {
//			System.out.println("직원번호 : " + customer.getAccountMgr() + "\t" + "고객관리(명) : " + customer.getCount());
//		}

		long endTime = System.currentTimeMillis(); // 코드 실행 후 시간 측정
		double time = (endTime - startTime) / 1000.0;
		System.out.println("처리시간 : " + time + "초");
	}

	public void bonusLogic() {
		// 고객 관리의 수를 센 customer 테이블의 empno과 일치하는 emp 테이블의 empno 사원의 보너스 처리 
		empList = empRepository.bonusLogic(customerList);
		for (Emp emp : empList) {
			System.out.println(
					"직원번호 : " + emp.getEmpno() + "\t" +
					"직원이름 : " + emp.getEname() + "\t" + 
					"직업 : "+ emp.getJob() + "\t" + 
					"급여 : " + emp.getSal() + "\t" + 
					"보너스 : " + emp.getComm());
		}
	}

	public void bonusCommit() {
		// bonusLogic에서 처리한 사원을 bonus 테이블에 insert
		bonusRepository.bonusCommit(empList);
	}
}
