package presentation;

import java.util.ArrayList;
import java.util.List;

import repository.CustomerRepository;
import service.CustomerImpl;
import table.Customer;

public class CustomerController {
	private CustomerRepository customerRepository;
	List<Customer> customerList = new ArrayList<>();
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void loadCustomerList() {
		long startTime = System.currentTimeMillis(); // 코드 실행 전 시간 측정
		
		// customerImpl에서 실행해온 결과를 List에 담기
		customerList = customerRepository.printCustomerList();
		
		// 사원 당 몇명의 고객을 담당하는지 출력
		for (Customer customer : customerList) {
			System.out.println("직원번호 : " + customer.getAccountMgr() + "\t" + "고객관리(명) : " + customer.getCount());
		}

		long endTime = System.currentTimeMillis(); // 코드 실행 후 시간 측정
		double time = (endTime - startTime) / 1000.0;
		System.out.println("처리시간 : " + time + "초");
	}
}
