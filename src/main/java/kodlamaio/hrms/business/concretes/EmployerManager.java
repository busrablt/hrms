package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao){
		super();
		this.employerDao = employerDao;
	}
	
	private boolean validationForEmployer(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getWebAdress()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getPassword())){
			return false;
		}
		
	  return true;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
	
	@Override
	public Result add(Employer employer) {
		if(getByEmail(employer.getEmail()).getData()!=null){
			return new ErrorResult("This email address already exists.");
		}
		if(!this.validationForEmployer(employer)) {
			return new ErrorResult("You have entered incomplete information. Please check your information again.");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer successfully added.");
		
	}

	@Override
	public DataResult<List<EmployerDto>> getDto() {
		return new SuccessDataResult<List<EmployerDto>>(this.employerDao.getDto());
	}

	
	

}
