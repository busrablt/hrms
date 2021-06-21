package kodlamaio.hrms.core.utilities.adapter;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdapter implements CheckMernisService {

    @Override
    public boolean checkIfRealTcNo(Candidate candidate) {
        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean serviceResult=false;

        try {

//            serviceResult = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
//                    candidate.getFirstName().toUpperCase(),
//                    candidate.getLastName().toUpperCase(),
//                    candidate.getBirthDate());

        } catch (Exception e) {

            System.out.println("Not a valid person");
        }

       return serviceResult; 
    }

	

}
