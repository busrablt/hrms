package kodlamaio.hrms.core.adapter;

import java.util.Date;

public class FakeMernis {
	public boolean candidateValidate(long identityNumber,String firstName,String lastName,Date birtDate) {
		System.out.println("Authentication successful." + firstName + " " + lastName);
		return true;
	}

}
