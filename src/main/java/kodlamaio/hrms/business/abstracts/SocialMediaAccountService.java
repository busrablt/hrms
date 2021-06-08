package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccountService {
	Result add (SocialMediaAccount socialMediaAccount);
	DataResult<List<SocialMediaAccount>> getByCandidate_Id(int candidateId);

}
