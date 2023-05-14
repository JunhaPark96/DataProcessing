package table;

import java.util.List;

public class Bonus {
	private List<Bonus> bonusList;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	public Bonus(String ename, String job, int sal, int comm) {
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	public List<Bonus> getBonusList() {
		return bonusList;
	}
	public void setBonusList(List<Bonus> bonusList) {
		this.bonusList = bonusList;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	
	
}
