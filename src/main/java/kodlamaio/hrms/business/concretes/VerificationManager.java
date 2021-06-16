package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {
	
	private VerificationDao verificationDao;
	
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao = verificationDao;
	}

	
	@Override
	public Result add(Verification verification) {
		this.verificationDao.save(verification);
		return new SuccessResult();
	}

	@Override
	public Result update(Verification verification) {
		this.verificationDao.save(verification);
		return new SuccessResult();
	}

	@Override
	public Result delete(Verification verification) {
		this.verificationDao.delete(verification);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Verification>> getAll() {
		return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll());
	}

	@Override
	public DataResult<Verification> getById(int id) {
		return new SuccessDataResult<Verification>(this.verificationDao.getById(id));
	}

}
