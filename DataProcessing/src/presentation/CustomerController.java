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

		customerList = customerRepository.printCustomerList();

		for (Customer customer : customerList) {
			System.out.println("직원번호 : " + customer.getAccountMgr() + "\t" + "고객관리(명) : " + customer.getCount());
		}

		long endTime = System.currentTimeMillis(); // 코드 실행 후 시간 측정
		double time = (endTime - startTime) / 1000.0;
		System.out.println("처리시간 : " + time + "초");
	}
}
