package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Employee employee){
		return this.employeeService.add(employee);
	}

	@GetMapping("/getById")
	public DataResult<Employee> getById(@RequestParam("id") int id){
		return this.employeeService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@GetMapping("/getEmployeeDto")
	public DataResult<List<EmployeeDto>> getDto() {
		return this.employeeService.getDto();
	}
}