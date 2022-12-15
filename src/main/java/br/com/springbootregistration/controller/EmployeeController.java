package br.com.springbootregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.springbootregistration.model.Employee;
import br.com.springbootregistration.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Lista de exibição dos funcionários
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, model);
	}

	@GetMapping("/showNewEmployeeForm")
	// criar atributos de modelo para vincular dados de formulário
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// salvando empregado no banco de dados
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
		// salvando empregado no banco de dados
		Employee employee = employeeService.getEmplooyeeById(id);
		// seleciona o valor a ser atualizado
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		// deletando empregado no banco de dados a partir de seu id
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 50;
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, null, null);
		List<Employee> employees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmployees", employees);
		return "index";
	}
}
