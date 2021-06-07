package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name ="url")
	private String url;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@OneToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
