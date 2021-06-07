package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingSkillDao;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;
@Service
public class ProgramminSkillManager implements ProgrammingSkillService {

	private ProgrammingSkillDao programmingSkillDao;
	
    @Autowired
	public ProgramminSkillManager(ProgrammingSkillDao programmingSkillDao) {
		super();
		this.programmingSkillDao = programmingSkillDao;
	}

	@Override
	public Result add(ProgrammingSkill programmingSkill) {
		this.programmingSkillDao.save(programmingSkill);
		return new  SuccessResult("Programming skils");
	}

	@Override
	public DataResult<ProgrammingSkill> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
