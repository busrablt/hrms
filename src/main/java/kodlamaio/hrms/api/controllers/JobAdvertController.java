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

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	@PostMapping("/addDto")
	public Result add(@RequestBody JobAdvertDto jobAdvertDto) {
		System.out.println("INFO" +jobAdvertDto.toString());
		return this.jobAdvertService.create(jobAdvertDto);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	} 
	
	
	@GetMapping("/getAllByPage")
	DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize){
		return this.jobAdvertService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<JobAdvert>> getAllSorted() {
		return this.jobAdvertService.getAllSorted();
	}
	
	@GetMapping("/getByNameJobAdvert")
	public DataResult<JobAdvert> getByProductName(@RequestParam String productName){
		return this.jobAdvertService.getByJobAdvertName(productName);
	}
	
	
	
	
}
