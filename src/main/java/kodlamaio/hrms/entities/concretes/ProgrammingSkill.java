package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "programming_skills")
public class ProgrammingSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "programming_name")
	private String programmingName;
	
	@ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

}
