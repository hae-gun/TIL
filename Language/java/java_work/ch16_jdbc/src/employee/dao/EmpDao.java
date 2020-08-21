package employee.dao;

import java.util.List;

import employee.dto.Employee;

public interface EmpDao {
	public List<Employee> selectAll();

	public List<Employee> selectName(String name);

	public boolean insertEmployee(Employee emp);

	public boolean deleteEmpl(int i);
}
