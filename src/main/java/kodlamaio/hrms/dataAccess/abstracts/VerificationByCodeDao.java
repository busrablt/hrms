package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationByCode;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode, Integer> {
    VerificationByCode getByUserId(int userId);
    VerificationByCode getById(int id);
}
