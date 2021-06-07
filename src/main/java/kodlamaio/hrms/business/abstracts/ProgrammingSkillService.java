package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillService {
	Result add(ProgrammingSkill programmingSkill);
	DataResult<List<ProgrammingSkill>> getAll();
	DataResult<ProgrammingSkill> getById(int id);

}
