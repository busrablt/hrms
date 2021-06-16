package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "verifications")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Verification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "status",columnDefinition="boolean default false")
	private boolean status;

	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();

	@Column(name = "verified_date")
	private LocalDateTime verifiedDate;
}