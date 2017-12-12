package team11.project.behaviorapp.Controllers.API.GP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by c1628725 on 07/12/2017.
 */
@RestController
@RequestMapping(path = "/api/gp")
public class GPPatientsAPI {

    @Autowired
    public GPPatientsAPI(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    private PatientRepository patientRepository;

    private PatientService patientService;

    @RequestMapping(path = "/{id}/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(path = "/{id}/patients/{patientId}/activities")
    public Collection<CustomList> getActivities(@PathVariable Long id, @PathVariable long patientId) {

        Collection<CustomList> activities = patientService.getActivityList(patientId);

        return activities;
    }

    @RequestMapping("{id}/patients/{patientId}/activities/statistics/completed")
    public List<Activities> getCompletedActivities(@PathVariable Long id, @PathVariable long patientId) {

        List<Activities> completedActivities = patientService.getCompletedActivities(patientId, true);

        return completedActivities;
    }
}
