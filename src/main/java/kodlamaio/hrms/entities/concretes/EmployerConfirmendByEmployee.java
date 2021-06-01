package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerConfirmendByEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name="is_confirmed",columnDefinition="boolean default false")
	private boolean isConfirmend;

}
