package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid Candidate candidate){
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	@GetMapping("/cv")
	public ResponseEntity<?> getCv(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateService.getCandidateCv(candidateId));
	}
	
	@GetMapping("/getCandidateDto")
	public DataResult<List<CandidateDto>> getDto(){
		return this.candidateService.getDto();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException 
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation errors");
		return errors;
	}	
	

}
