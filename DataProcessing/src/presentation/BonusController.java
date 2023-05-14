package presentation;

import java.util.ArrayList;
import java.util.List;

import repository.BonusRepository;
import repository.EmpRepository;
import table.Customer;
import table.Emp;

public class BonusController {
	private BonusRepository bonusRepository;
	List<Emp> empList = new ArrayList<>();
	
	public BonusController(BonusRepository bonusRepository, List<Emp> empList) {
		this.bonusRepository = bonusRepository;
		this.empList = empList;
	}
	public void bonusCommit() {
		bonusRepository.bonusCommit(empList);
	}
}
