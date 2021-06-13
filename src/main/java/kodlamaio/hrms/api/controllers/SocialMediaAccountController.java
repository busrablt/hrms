package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;

@CrossOrigin
@RestController
@RequestMapping("/api/socialMediaAcounts")
public class SocialMediaAccountController {
	private SocialMediaAccountService socialMediaAccountService;

	@Autowired
	public SocialMediaAccountController(SocialMediaAccountService socialMediaAccountService) {
		super();
		this.socialMediaAccountService = socialMediaAccountService;
	}
	
	@PostMapping("/add")
	public Result add(SocialMediaAccount socialMediaAccount) {
		return this.socialMediaAccountService.add(socialMediaAccount);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<SocialMediaAccount>> getByCandidateId(int candidateId){
		return this.socialMediaAccountService.getByCandidate_Id(candidateId);
	}

}
