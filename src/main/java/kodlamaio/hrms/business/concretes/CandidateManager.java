package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapter.CheckMernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	private CheckMernisService checkMernisService;
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CheckMernisService checkMernisService) {
		super();
		this.candidateDao = candidateDao;
		this.checkMernisService = checkMernisService;
	}
	
	private boolean validationForCandidate(Candidate candidate) {
		if (Objects.isNull(candidate.getIdentityNumber()) || Objects.isNull(candidate.getFirstName()) || Objects.isNull(candidate.getLastName()) 
				|| Objects.isNull(candidate.getEmail()) || Objects.isNull(candidate.getPassword()) || Objects.isNull(candidate.getBirthDate())) {
			return false;
		}
		
	  return true;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new  SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}


	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentityNumber(identityNumber));
	}
	
	@Override
	public Result add(Candidate candidate) {
		if(!checkMernisService.checkIfRealTcNo(candidate)){
		return new ErrorResult("Not a valid person");
     	}
		else
		if(!validationForCandidate(candidate)) {
			return new ErrorResult("You have entered incomplete information. Please check your information again.");
		}
		if(getByEmail(candidate.getEmail()).getData()!=null){
			return new ErrorResult("This email address already exists.");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate successfully added.");
	}


}
