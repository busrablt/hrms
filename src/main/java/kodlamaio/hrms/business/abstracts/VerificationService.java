package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Verification;

public interface VerificationService {
	
	Result add(Verification verification);
	Result update(Verification verification);
	Result delete(Verification verification);
	DataResult<List<Verification>> getAll();
    DataResult<Verification> getById(int id);

}