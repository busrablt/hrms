package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationByCode;

public interface VerificationByCodeService {
	
	Result add(VerificationByCode verificationByCode);
	Result update(VerificationByCode verificationByCode);
	Result delete(VerificationByCode verificationByCode);
	DataResult<List<VerificationByCode>> getAll();
	DataResult<VerificationByCode> getById(int id);
	DataResult<VerificationByCode> getByUserId(int userId);
}