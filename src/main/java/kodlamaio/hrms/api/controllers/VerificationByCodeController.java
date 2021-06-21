package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationByCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationByCode;

@CrossOrigin
@RestController
@RequestMapping("/api/verificationsByCode")
public class VerificationByCodeController {
	
	private VerificationByCodeService verificationByCodeService;
	
	@Autowired
	public VerificationByCodeController(VerificationByCodeService verificationByCodeService) {
		super();
		this.verificationByCodeService = verificationByCodeService;
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody VerificationByCode verificationByCode) {
		return this.verificationByCodeService.update(verificationByCode);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody VerificationByCode verificationByCode) {
		return this.verificationByCodeService.delete(verificationByCode);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<VerificationByCode>> getAll() {
		return this.verificationByCodeService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<VerificationByCode> getById(int id) {
		return this.verificationByCodeService.getById(id);
	}

	
	

}
