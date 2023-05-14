package table;

import java.util.List;
import java.util.Objects;

public class Emp {
	private List<Emp> empList;
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp(int empno, String ename, String job, int mgr, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	
	public List<Emp> getEmpList() {
		return empList;
	}


	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
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


	public int getMgr() {
		return mgr;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
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


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Override
	public int hashCode() {
		return Objects.hash(comm, deptno, empno, ename, job, mgr, sal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return comm == other.comm && deptno == other.deptno && empno == other.empno
				&& Objects.equals(ename, other.ename) && Objects.equals(job, other.job) && mgr == other.mgr
				&& sal == other.sal;
	}
	
	
}
