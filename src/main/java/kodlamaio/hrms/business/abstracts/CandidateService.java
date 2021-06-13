package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	DataResult<Candidate > getByEmail(String email);
	DataResult<Candidate > getByIdentityNumber(String identityNumber);
	DataResult<Candidate> getById(int id);
	DataResult<CvDto> getCandidateCv(int candidateId);
	DataResult<List<CandidateDto>> getDto();

}
