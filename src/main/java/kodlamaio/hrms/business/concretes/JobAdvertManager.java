package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert added");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"jobAdvertName");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll(int pagenNo, int pageSize) {
		Pageable pageable = PageRequest.of(pagenNo, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(pageable).getContent());
	}
	
	@Override
	public DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertName(jobAdvertName));
	}
	
	@Override
	public DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertNameAndJobPosition_Id(jobAdvertName, jobPositionId));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByJobAdvertNameAndEmployer(String jobAdvertName, int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobAdvertNameAndEmployer_Id(jobAdvertName, employerId));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobAdvertNameAndCity_Id(jobAdvertName, cityId));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByNameAndCity(String jobAdvertName, int cityId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByNameAndCity(jobAdvertName, cityId));
	}
	


}