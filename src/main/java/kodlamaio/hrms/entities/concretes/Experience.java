package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experiences")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace")
	private String workplace;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
