package kodlamaio.hrms.core.adapter;

import java.util.Date;

import org.springframework.stereotype.Service;


@Service
public class MernisServiceAdapter implements CheckMernisService {

	@Override
	public boolean checkIfRealCandidate(long identityNumber, String firstName, String lastName, Date birthDate) {
		FakeMernis checkCandidate = new FakeMernis();
		boolean result = checkCandidate.candidateValidate(identityNumber,firstName, lastName,birthDate);
		return result;
	}

	

}
