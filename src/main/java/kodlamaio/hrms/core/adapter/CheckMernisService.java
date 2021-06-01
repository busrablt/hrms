package kodlamaio.hrms.core.adapter;

import java.util.Date;


public interface CheckMernisService {
	public boolean checkIfRealCandidate(long identityNumber,String firstName,String lastName,Date birthDate);

}
