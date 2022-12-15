package br.com.springbootregistration.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.springbootregistration.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();
	void saveEmployee(Employee employee); 
	Employee getEmplooyeeById(long id);
	void deleteEmployee(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortfield, String sortDiretcion);
}
