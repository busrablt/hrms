package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto { 
	private int jobPositionId;
	private int employerId;
	private int cityId;
	private int salaryMax;
	private int salaryMin;
	private int openPositionCount;
	private String description;
	private LocalDate applicationDeadline;
	private boolean isOpen;
	

}
