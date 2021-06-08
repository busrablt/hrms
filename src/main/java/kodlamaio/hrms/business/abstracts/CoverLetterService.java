package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result add(CoverLetter coverLetter);
	DataResult<CoverLetter> getByCandidateId(int candidateId);

}
