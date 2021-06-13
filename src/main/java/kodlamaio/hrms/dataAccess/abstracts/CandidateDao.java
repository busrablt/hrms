package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate getByEmail(String email); 
	Candidate getByIdentityNumber(String identityNumber); 
	Candidate getById(int id);
	@Query("Select new  kodlamaio.hrms.entities.dtos.CandidateDto"
	  		+ "(c.firstName, c.lastName, c.email, i.url) "
	  		+ "From Candidate c Inner Join c.images i")
	List<CandidateDto> getDto();

}
