package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_advert_name")
	private String jobAdvertName;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id") // employerId -> employer_id
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "working_time_id")
	private WorkingTime workingTime;
	
	@ManyToOne
	@JoinColumn(name = "workplace_id")
	private Workplace workplace;
	
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
	
	@Column(name = "published_date")
	private LocalDate publishedDate;
	
	@Column (name = "is_open",columnDefinition="boolean default false")
	private boolean isOpen;

}
