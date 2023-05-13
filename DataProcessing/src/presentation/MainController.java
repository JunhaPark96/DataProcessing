package presentation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.JDBC;
import repository.EmpRepository;
import service.CustomerImpl;
import service.EmpImpl;

public class MainController {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		JDBC jdbc = JDBC.getInstance();
		
		CustomerImpl customerImpl = new CustomerImpl();
		EmpImpl empImpl = new EmpImpl();
		
		boolean isExit = false;
		try {
			while (!isExit) {
			    System.out.println("1. 데이터 조회, 2. 보너스 처리, 3. 저장");
			    int target = scanner.nextInt();
			    if (target == 1) {
			    	customerImpl.customerList(); // customer 테이블에 담당 사원 조희
			    } else if (target == 2) {
//			    	bonusLogic(); // 조건에 따라 보너스 처리
			    } else if (target == 3) {
//			    	commitExit(); // 데이터 처리 commit 후 종료
			    }
			    else {
			        System.out.println("다시 입력해주십시오");
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


