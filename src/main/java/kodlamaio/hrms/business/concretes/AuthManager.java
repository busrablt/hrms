package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationByCodeService;
import kodlamaio.hrms.business.abstracts.VerificationByEmployeeService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.CodeGenarator;
import kodlamaio.hrms.core.verification.MailVerification;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationByCode;
import kodlamaio.hrms.entities.concretes.VerificationByEmployee;
import lombok.var;

@Service
public class AuthManager implements AuthService {

	private EmployerService employerService;
	private CandidateService candidateService;
	private UserService userService;
	private VerificationByCodeService verificationByCodeService;
    private VerificationByEmployeeService verificationByEmployeeService;
    private MailVerification mailVerification ;
	
    @Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
		    VerificationByCodeService verificationByCodeService,VerificationByEmployeeService verificationByEmployeeService,
		    MailVerification mailVerification,UserService userService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationByCodeService = verificationByCodeService;
		this.verificationByEmployeeService = verificationByEmployeeService;
		this.mailVerification = mailVerification;
	}
	

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		var result =BusinessRules.run(this.confirmPassword(employer.getPassword(), confirmPassword),
				this.userExist(employer.getEmail()),this.checkEmailMatch(employer));
		if (result != null) {
            return result;
        }
	
		var addEmployer = this.employerService.add(employer);
		
		if(!addEmployer.isSuccess()) {
			
			return new ErrorResult("Employer not registered.");	
		}
		
		var code = CodeGenarator.sendVerificationCode();
		VerificationByCode verifyCodeEntity = new VerificationByCode(employer.getId(), code);
		VerificationByEmployee verifyEmployeeEntity = new VerificationByEmployee(employer.getId(), null);
		this.verificationByCodeService.add(verifyCodeEntity);
		this.verificationByEmployeeService.add(verifyEmployeeEntity);
		this.mailVerification.sendMail(employer.getEmail(), code);
        return new SuccessResult();
		
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		var result =BusinessRules.run(this.confirmPassword(confirmPassword, confirmPassword),
				this.userExist(candidate.getEmail()));
		if (result != null) {
            return result;
        }
		
        var addCandidate = this.candidateService.add(candidate);
        
         if(!addCandidate.isSuccess()) {
			
			return new ErrorResult("Employer not registered.");	
		}

        var code = CodeGenarator.sendVerificationCode();
		VerificationByCode verifyCodeEntity = new VerificationByCode(candidate.getId(), code);
		this.verificationByCodeService.add(verifyCodeEntity);
		this.mailVerification.sendMail(candidate.getEmail(), code);
        return new SuccessResult();

	}
	
	public Result confirmPassword(String password,String confirmPassword) 
    {    
        if (password.equals(confirmPassword)) {   
        	 return new SuccessResult();
        }
        return new ErrorResult("Password does not match. Please re-enter your password.");
    }
    public Result checkEmailMatch(Employer employer) {
        var mailDomain = employer.getEmail().split("@")[1];
        return mailDomain.equals(employer.getWebAdress()) ? new SuccessResult() :
                new ErrorResult("E-mail domain and web address does not match.");
    }
    
	private Result userExist(String email) {
		if (this.userService.getByEmail(email).getData() == null)
         {
            return new SuccessResult();
        }
        return new ErrorResult();
	}


	

}
