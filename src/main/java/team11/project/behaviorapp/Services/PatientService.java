package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;

import java.util.Collection;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ActivityRepository activityRepository;

    public List<Patient>getAllPatients(){
        return patientRepository.findAll();
    }
    public Collection<CustomList>getActivityList(Long id) {

        Patient p = patientRepository.findById(id);

        Collection<CustomList> activities = activityRepository.findActivitiesByPatients(p);

        return activities;
    }

    public Patient getSpecificRecord(@PathVariable Long id){
        return patientRepository.findOne(id);

    }

    public List<Patient> getPatientByName(@PathVariable String firstname){
        return patientRepository.findPatientByFirstname(firstname);
    }

}
