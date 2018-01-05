package team11.project.behaviorapp.Controllers.API.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

import java.util.List;

/**
 * Created by c1628725 on 07/12/2017.
 */
@RestController
@RequestMapping(path = "/api/patient")
public class PatientIndexAPI {

    @Autowired
    public PatientIndexAPI(PatientService patientService) {
        this.patientService = patientService;
    }

    private PatientService patientService;

    //Done
    @RequestMapping("{id}/statistics/last-activities") //activities/patient/index")
    public List<Activities> getPatientsLastActivities(@PathVariable Long id ) {

        List<Activities> completedActivities = patientService.lastActivitiesOfPatient(id, true);

        return completedActivities;
    }

    //Done
    @RequestMapping("{id}/statistics/activities-by-days")//activities/days")
    public List<Activities> getActivitiesByDays(@PathVariable Long id){

        List <Activities> activitiesByDays = patientService.getActivitiesByDay(id);

        return activitiesByDays;

    }

    //Done
    @RequestMapping("{id}/statistics/average")//activities/average/before/after")
    public List<Activities> activitiesBeforeAfter(@PathVariable Long id){

        return patientService.getActivitiesByBeforeAndAfter(id);
    }

    @RequestMapping("{id}/activities/difference")//activities/average/before/after")
    public List<Activities> differenceGraph(@PathVariable Long id){

        return patientService.differenceGraph(id);
    }


}
