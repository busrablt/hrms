package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationByEmployee;

public interface VerificationByEmployeeService {
	Result add(VerificationByEmployee verificationByEmployee);
	Result update(VerificationByEmployee verificationByEmployee, int employeeId);
    Result delete(VerificationByEmployee verificationByEmployee);
	DataResult<List<VerificationByEmployee>> getAll();
    DataResult<VerificationByEmployee> getById(int id);
	DataResult<VerificationByEmployee> getByEmployerId(int employerId);
}