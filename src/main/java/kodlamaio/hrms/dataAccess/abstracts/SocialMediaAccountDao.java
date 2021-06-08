package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount, Integer> {
	List<SocialMediaAccount> getByCandidate_Id(int candidateId);

}
