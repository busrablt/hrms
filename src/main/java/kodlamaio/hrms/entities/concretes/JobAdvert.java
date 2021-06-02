package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advert")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_advert_name")
	private String jobAdvertName;
	
	@ManyToOne()
	@Column(name = "employer_id")
	private int employerId;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	@Column(name = "job_position_id")
	private int jobPositionId;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@Column(name = "application _deadline")
	private LocalDate applicationDeadline;

}
