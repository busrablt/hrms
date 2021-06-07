package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.var;

@Service
public class AuthManager implements AuthService {

	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
	}
	
	
	public boolean confirmPassword(String password,String confirmPassword) 
    {    
        if (password.equals(confirmPassword)) {
            
            return true;
        }
        return false;
    }

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		
		if(!this.confirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
		var result = this.employerService.add(employer);
		
		if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(employer.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		}
		
		return new ErrorResult();
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		
		if(!this.confirmPassword(candidate.getPassword(), confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
        var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(candidate.getEmail())) {
				return new SuccessResult("Employer registered.");
			}
		}
		return new ErrorResult();
		

	}

	

}
