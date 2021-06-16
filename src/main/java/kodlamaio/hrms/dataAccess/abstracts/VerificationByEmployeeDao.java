package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationByEmployee;

public interface VerificationByEmployeeDao extends JpaRepository<VerificationByEmployee, Integer> {
    VerificationByEmployee getByEmployerId(int employerId);
    VerificationByEmployee getById(int id);
}