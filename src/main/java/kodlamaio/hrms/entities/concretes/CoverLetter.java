package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cover_letter")
public class CoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}