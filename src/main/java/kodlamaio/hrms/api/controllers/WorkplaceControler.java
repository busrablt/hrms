package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkplaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Workplace;


@CrossOrigin
@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceControler {
	private WorkplaceService  workplaceService;

	public WorkplaceControler(WorkplaceService workplaceService) {
		super();
		this.workplaceService = workplaceService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Workplace>> getAll(){
		return this.workplaceService.getAll();
	}

}
