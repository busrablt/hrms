package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_positions")
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "position")
    private String position;
    
    @OneToMany(mappedBy = "jobPosition")
	private List<JobAdvert> jobAdverts;
    
    
}
