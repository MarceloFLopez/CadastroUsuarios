package br.com.springbootregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springbootregistration.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
