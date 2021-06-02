package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add (JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllSorted();
    DataResult<List<JobAdvert>> getAll(int pagenNo, int pageSize);
	DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName);
	DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId);
	DataResult<List<JobAdvert>> getByJobAdvertNameAndEmployer(String jobAdvertName, int employerId);
	DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId);
	

}
