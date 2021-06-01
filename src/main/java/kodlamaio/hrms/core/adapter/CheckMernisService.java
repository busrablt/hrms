package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CheckMernisService {
    boolean checkIfRealTcNo(Candidate candidate);


}