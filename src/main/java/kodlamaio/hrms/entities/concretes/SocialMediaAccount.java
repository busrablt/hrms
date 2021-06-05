package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="social_media_accounts")
public class SocialMediaAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="link")
	private String link;
	
	@ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
	

}
