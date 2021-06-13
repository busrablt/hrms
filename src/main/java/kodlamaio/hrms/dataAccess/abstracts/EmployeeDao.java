package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employee getById(int id);
	@Query("Select new  kodlamaio.hrms.entities.dtos.EmployeeDto"
	  		+ "(e.firstName, e.lastName,e.email, e.position, i.url) "
	  		+ "From Employee e Inner Join e.images i")
	List<EmployeeDto> getDto();
}

