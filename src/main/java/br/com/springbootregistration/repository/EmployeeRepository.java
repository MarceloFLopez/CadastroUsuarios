package br.com.springbootregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springbootregistration.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("SELECT p FROM Employee p WHERE p.firstName like %?1%")
	List<Employee> findByFirstName(String firstName);
}
