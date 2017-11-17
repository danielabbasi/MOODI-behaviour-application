package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.PatientRepository;

import java.util.List;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient>getAllPatients(){
        return patientRepository.findAll();
    }
}
