package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SocialMediaAccountService;
import kodlamaio.hrms.core.utilities.adapter.CheckMernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService{
	//private CheckMernisService checkMernisService;
	private CandidateDao candidateDao;
	private ImageService imageService;
	private CoverLetterService coverLetterService;
	private ExperienceService experienceService;
	private SchoolService schoolService;
	private LanguageService languageService;
	private ProgrammingSkillService programmingSkillService;
	private SocialMediaAccountService socialMediaAccountService;
	
	@Autowired
	public CandidateManager( CandidateDao candidateDao, ImageService imageService,
			CoverLetterService coverLetterService, ExperienceService experienceService, SchoolService schoolService,
			LanguageService languageService, ProgrammingSkillService programmingSkillService,
			SocialMediaAccountService socialMediaAccountService) {
		super();
		//this.checkMernisService = checkMernisService;
		this.candidateDao = candidateDao;
		this.imageService = imageService;
		this.coverLetterService = coverLetterService;
		this.experienceService = experienceService;
		this.schoolService = schoolService;
		this.languageService = languageService;
		this.programmingSkillService = programmingSkillService;
		this.socialMediaAccountService = socialMediaAccountService;
	}



	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new  SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}


	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email));
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber));
	}
	
	@Override
	public Result add(Candidate candidate) {
//		if(!checkMernisService.checkIfRealTcNo(candidate)){
//		return new ErrorResult("Not a valid person");
//     	}
		if(getByEmail(candidate.getEmail()).getData()!=null){
			return new ErrorResult("This email address already exists.");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate successfully added.");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	@Override
	public DataResult<CvDto> getCandidateCv(int candidateId) {
		CvDto cv = new CvDto();
		cv.setUser(this.getById(candidateId).getData());
		cv.setImage(this.imageService.getByUserId(candidateId).getData());
		cv.setCoverLetter(this.coverLetterService.getByCandidateId(candidateId).getData());
		cv.setSchools(this.schoolService.getByCandidateId(candidateId).getData());
		cv.setLanguages(this.languageService.getByCandidate_Id(candidateId).getData());
	    cv.setProgrammingSkills(this.programmingSkillService.getByCandidateId(candidateId).getData());
		cv.setExperiences(this.experienceService.getByCandidate_Id(candidateId).getData());
		cv.setSocialMediaAccounts(this.socialMediaAccountService.getByCandidate_Id(candidateId).getData());
		return new SuccessDataResult<CvDto>(cv);
	
	}


	@Override
	public DataResult<List<CandidateDto>> getDto() {
		return new SuccessDataResult<List<CandidateDto>>(this.candidateDao.getDto());
	}


}
