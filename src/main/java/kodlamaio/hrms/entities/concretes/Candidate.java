package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@Table(name="candidates")
public class Candidate extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_date")
	private int birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
    private List<School> schools;

	@JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Language> languages;

  
	@JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<ProgrammingSkill> programmingSkills;

	@JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

	@JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<SocialMediaAccount> socialMediaAccounts;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate", optional=false, fetch=FetchType.LAZY)
	private Image image;
	
	
	
	 
	

}
