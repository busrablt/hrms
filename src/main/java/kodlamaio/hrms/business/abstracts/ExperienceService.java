package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	DataResult<List<Experience>> getAll();
	DataResult<Experience> getById(int id);
	DataResult<List<Experience>> getByCandidate_Id(int candidateId);
	
}
