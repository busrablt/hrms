package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvert;


public interface JobAdvertDao extends JpaRepository <JobAdvert,Integer>{
	JobAdvert getByJobAdvertName(String jobAdvertName);
	JobAdvert getByJobAdvertNameAndJobPosition_JobPositionId(String jobAdvertName, int jobPositionId);
	List<JobAdvert> getByJobAdvertNameAndEmployer_EmployerId(String jobAdvertName, int employerId);
	List<JobAdvert> getByJobAdvertNameAndCity_CityId(String jobAdvertName, int cityId);
	

}
