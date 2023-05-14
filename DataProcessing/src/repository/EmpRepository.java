package repository;

import java.util.List;

import table.Customer;
import table.Emp;

public interface EmpRepository {
	List<Emp> bonusLogic(List<Customer> customerList);
}
