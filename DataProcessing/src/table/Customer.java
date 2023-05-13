package table;

import java.util.Objects;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private int accountMgr;
	
	public Customer(String id, String pwd, String name, int accountMgr) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.accountMgr = accountMgr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountMgr() {
		return accountMgr;
	}
	public void setAccountMgr(int accountMgr) {
		this.accountMgr = accountMgr;
	}
	
	
	
	
}
