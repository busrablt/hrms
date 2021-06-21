package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
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
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkplaceDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	private JobPositionDao jobPositionDao;
    private EmployerDao employerDao;
    private CityDao cityDao;
    private WorkingTimeDao workingTimeDao;
    private WorkplaceDao workplaceDao;
	
    @Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, JobPositionDao jobPositionDao, EmployerDao employerDao,
			CityDao cityDao, WorkplaceDao workplaceDao, WorkingTimeDao workingTimeDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.jobPositionDao = jobPositionDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.workingTimeDao = workingTimeDao;
		this.workplaceDao = workplaceDao;
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

	@Override
	public Result create(JobAdvertDto jobAdvertDto) {
		
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setId(0);
		jobAdvert.setJobPosition(this.jobPositionDao.getById(jobAdvertDto.getJobPositionId()));
		jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
		jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
		jobAdvert.setWorkingTime(this.workingTimeDao.getById(jobAdvertDto.getWorkingTimeId()));
		jobAdvert.setWorkplace(this.workplaceDao.getById(jobAdvertDto.getWorkplaceId()));
		jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setDescription(jobAdvertDto.getDescription());
		jobAdvert.setPublishedDate(LocalDate.now());
		jobAdvert.setApplicationDeadline(jobAdvertDto.getApplicationDeadline());
		jobAdvert.setOpen(true);
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert added.");
		
	}
	


}