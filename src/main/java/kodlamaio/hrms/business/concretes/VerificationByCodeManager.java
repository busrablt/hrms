package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationByCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationByCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationByCode;

@Service
public class VerificationByCodeManager implements VerificationByCodeService{

	private VerificationByCodeDao verificationByCodeDao;
	@Autowired
	public VerificationByCodeManager(VerificationByCodeDao verificationByCodeDao) {
		super();
		this.verificationByCodeDao = verificationByCodeDao;
	}

	@Override
	public Result add(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.save(verificationByCode);
		return new SuccessResult();
	}

	@Override
	public Result update(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.save(verificationByCode);
		return new SuccessResult();
	}

	@Override
	public Result delete(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.delete(verificationByCode);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<VerificationByCode>> getAll() {
		return new SuccessDataResult<List<VerificationByCode>>(this.verificationByCodeDao.findAll());
	}

	@Override
	public DataResult<VerificationByCode> getById(int id) {
		return new SuccessDataResult<VerificationByCode>(this.verificationByCodeDao.getById(id));
	}

	@Override
	public DataResult<VerificationByCode> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
