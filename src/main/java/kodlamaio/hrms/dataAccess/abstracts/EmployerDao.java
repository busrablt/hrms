package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	Employer findByEmail(String email);
	@Query("Select new  kodlamaio.hrms.entities.dtos.EmployerDto"
	  		+ "(e.companyName,e.email, e.webAdress, e.phoneNumber, i.url) "
	  		+ "From Employer e Inner Join e.images i")
	List<EmployerDto> getDto();

}
