package table;

import java.util.List;
import java.util.Objects;

public class Customer {
	private List<Customer> customerList;
	private int count;
	private int accountMgr;
	
	public Customer() {
	}

	public Customer(int accountMgr, int count) {
		this.accountMgr = accountMgr;
		this.count = count;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAccountMgr() {
		return accountMgr;
	}

	public void setAccountMgr(int accountMgr) {
		this.accountMgr = accountMgr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountMgr, count, customerList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return accountMgr == other.accountMgr && count == other.count
				&& Objects.equals(customerList, other.customerList);
	}
}
