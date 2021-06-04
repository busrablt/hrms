package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
@Entity
@Table(name = "job_positions")
public class JobPosition {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "position")
    private String position;
    
    @OneToMany(mappedBy = "jobPosition")
	private List<JobAdvert> jobAdverts;
    
    
}
