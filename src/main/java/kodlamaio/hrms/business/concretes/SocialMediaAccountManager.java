package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService{

	private SocialMediaAccountDao socialMediaAccountDao;
	@Autowired
	public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao) {
		super();
		this.socialMediaAccountDao = socialMediaAccountDao;
	}

	@Override
	public Result add(SocialMediaAccount socialMediaAccount) {
		this.socialMediaAccountDao.save(socialMediaAccount);
		return new SuccessResult("Social media account added.");
	}

	@Override
	public DataResult<List<SocialMediaAccount>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccountDao.getByCandidate_Id(candidateId));
	}

	
	
}
