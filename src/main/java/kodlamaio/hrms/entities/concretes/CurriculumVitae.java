package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name= "cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "curriculumVitae")
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<ProgrammingSkill> programmingSkills;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<SocialMediaAccount> socialMediaAccounts;

}
