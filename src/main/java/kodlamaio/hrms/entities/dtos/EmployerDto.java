package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
	private String companyName;
	private String email;
	private String webAdress;
	private String phoneNumber;
	private String url;

}
