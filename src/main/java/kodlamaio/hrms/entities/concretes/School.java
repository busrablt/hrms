package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="departmant")
	private String departmant;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="graduated_date")
	private LocalDate graduatedDate;
	
	@ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

}
