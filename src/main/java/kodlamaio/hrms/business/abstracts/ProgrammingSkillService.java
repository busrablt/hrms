package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillService {
	Result add(ProgrammingSkill programmingSkill);
	DataResult<ProgrammingSkill> getAll();

}
