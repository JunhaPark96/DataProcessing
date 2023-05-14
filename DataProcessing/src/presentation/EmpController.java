package presentation;

import java.util.ArrayList;
import java.util.List;

import repository.EmpRepository;
import table.Customer;
import table.Emp;

public class EmpController {
	private EmpRepository empRepository;
	List<Emp> empList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();

	public EmpController(EmpRepository empRepository, List<Customer> customerList) {
		this.empRepository = empRepository;
		this.customerList = customerList;
	}

	public void bonusLogic() {
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

}
