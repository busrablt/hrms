package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationByEmployee;

@RestController
@RequestMapping("/api/verificationsByEmployee")
@CrossOrigin
public class VerificationByEmployeeController {
	private VerificationByEmployeeService verificationByEmployeeService;

	@Autowired
	public VerificationByEmployeeController(VerificationByEmployeeService verificationByEmployeeService) {
		super();
		this.verificationByEmployeeService = verificationByEmployeeService;
	}
	
	@PostMapping("/update")
    public Result update(@RequestBody VerificationByEmployee verificationByEmployee, int employeeId) {
        return this.verificationByEmployeeService.update(verificationByEmployee, employeeId);
    }
	  
	@PostMapping("/delete")
    public Result delete(@RequestBody VerificationByEmployee verificationByEmployee) {
        return this.verificationByEmployeeService.delete(verificationByEmployee);
    }
	
	@GetMapping("/getAll")
    public DataResult<List<VerificationByEmployee>> getAll() {
        return verificationByEmployeeService.getAll();
    }
	
	 @GetMapping("/getById")
	 public DataResult<VerificationByEmployee> getById(@RequestBody int id) {
	      return verificationByEmployeeService.getById(id);
	 }

	    

}
