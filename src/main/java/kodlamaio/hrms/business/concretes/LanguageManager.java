package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Language added.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<List<Language>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByCandidate_Id(candidateId));
	}

	

}
