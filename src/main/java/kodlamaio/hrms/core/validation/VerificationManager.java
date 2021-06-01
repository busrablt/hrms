package kodlamaio.hrms.core.validation;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public boolean sendVerificationCode(String emailAddress) {
	    UUID uuid = UUID.randomUUID();
	    String code= uuid.toString();
		System.out.println(emailAddress +"Verification code sent to address . Verification code:" + code );
		return true;
	}

	
	

	
}
