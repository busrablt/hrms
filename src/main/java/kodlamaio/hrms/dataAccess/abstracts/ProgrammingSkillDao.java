package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill, Integer> {
	ProgrammingSkill getById(int id);
	List<ProgrammingSkill> getByCandidate_Id(int candidateId);

}
