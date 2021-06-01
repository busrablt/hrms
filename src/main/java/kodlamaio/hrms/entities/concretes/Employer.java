package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="telefon_number")
	private String telefonNumber;
	
	

}
