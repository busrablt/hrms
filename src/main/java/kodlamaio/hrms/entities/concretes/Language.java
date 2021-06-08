package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="langauge")
	private String language;
	
	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "level")
	private int level;
	
	@ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}