  
package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

public interface EmployeeService {
	Result add(Employee employee);
	DataResult<Employee> getById(int id);
	DataResult<List<Employee>> getAll();
	DataResult<List<EmployeeDto>> getDto();
}