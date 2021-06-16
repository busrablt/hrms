package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "verifications_by_employee")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByEmployee extends Verification {

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "employee_id")
	private Integer employeeId;
}
