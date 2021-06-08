package kodlamaio.hrms.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
	
	@Email(message = "Invalid email address. Please enter your email address correctly.")
	@NotBlank
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user", optional=false, fetch=FetchType.LAZY)
	private Image image;

}
