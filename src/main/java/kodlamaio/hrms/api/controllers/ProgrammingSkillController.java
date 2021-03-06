package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

@CrossOrigin
@RestController
@RequestMapping("api/programmingSkills")
public class ProgrammingSkillController {
	private ProgrammingSkillService programmingSkillService;

	@Autowired
	public ProgrammingSkillController(ProgrammingSkillService programmingSkillService) {
		super();
		this.programmingSkillService = programmingSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.add(programmingSkill);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<ProgrammingSkill>> getByCandidateId(int candidateId) {
		return this.programmingSkillService.getByCandidateId(candidateId);
	}

}
