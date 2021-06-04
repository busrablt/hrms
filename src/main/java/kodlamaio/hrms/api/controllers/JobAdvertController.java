package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;


@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert product) {
		return this.jobAdvertService.add(product);
	}
	
	@GetMapping("/getall")
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
