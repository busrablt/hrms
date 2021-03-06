package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByEmail(String email);
	Result add(Employer employer);
	DataResult<List<EmployerDto>> getDto();
	DataResult<Employer> getById(int id);
	


}
