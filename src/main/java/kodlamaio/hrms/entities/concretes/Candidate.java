package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.*;

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
	
	@OneToMany(mappedBy = "candidate")
	List<CurriculumVitae> curriculumVitaes;
	
	 
	

}
