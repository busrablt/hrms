package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name="verification_codes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private LocalDate confirmedDate=LocalDate.now();

}
