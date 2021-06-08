package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private User user;
	private Image image;
	private CoverLetter coverLetter;
	private List<School> schools;
	private List<ProgrammingSkill>	programmingSkills;
	private List<Language> languages;
	private List<Experience> experiences;
	private List<SocialMediaAccount> socialMediaAccounts;

}
