package repository;

import java.util.List;

import table.Emp;

public interface BonusRepository {
	public void bonusCommit(List<Emp> empList);
}
