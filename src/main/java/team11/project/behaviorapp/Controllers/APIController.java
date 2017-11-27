package team11.project.behaviorapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.ActivityCreationService;
import team11.project.behaviorapp.Services.ActivityRatingService;
import team11.project.behaviorapp.Services.ActivityService;
import team11.project.behaviorapp.Services.PatientService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/patient")
public class APIController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private ActivityCreationService activityCreationService;
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityRatingService activityRatingService;

    @RequestMapping(path = "/activities/create", method = RequestMethod.POST)
    public String createActivity(@RequestParam final String activityName, @RequestParam final String date) throws ParseException {
        //Source adapted from https://stackoverflow.com/questions/4496359/how-to-parse-date-string-to-date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        activityCreationService.createActivity(1, activityName, dateFormat.parse(date));

        return "Activity created.";
    }

    @RequestMapping(value = "/one/update", method = RequestMethod.PUT)
    public String updateOneActivity(@RequestParam  String name, @RequestParam String date)throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        Activities activities = new Activities();
        activities.setId(3L);
        activities.setName(name);
        activities.setActivityDate(dateFormat.parse(date));
        activities.setIsCompleted(false);
        activities.setIsDeleted(false);
        activities.setRating(null);
        activityService.saveActivity(activities);
        return "Activity updated";
    }




    @RequestMapping(path = "/All")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(path = "/activities/all")
    public List<Activities> getAllActivities(){
        return activityRepository.findAll();
    }



    @RequestMapping("/patient/specific/{id}")
    public Patient getSinglePatent(@PathVariable Long id){
        return patientRepository.findOne(id);
    }

    @RequestMapping(path = "/{id}/activities")
    public Collection<CustomList> getActivities(@PathVariable Long id) {

        Collection<CustomList> activities = patientService.getActivityList(id);

        return activities;
    }

    @RequestMapping("/test/test/lol/{isCompleted}")
    public List<Activities> getCompletedActivities(@PathVariable Boolean isCompleted ) {
        return activityRepository.findActivitiesByIsCompleted(isCompleted);

    }

    @RequestMapping("/test/test/{id}/test/{isCompleted}")
    public List<Activities> getCompletedActivities(@PathVariable Long id, @PathVariable Boolean isCompleted ) {

        List<Activities> upcomingActivities = patientService.getUpcomingActivities(id, isCompleted);

        return upcomingActivities;

    }




    @RequestMapping("test/{firstname}")
    public List<Patient> getPatientByName(@PathVariable String firstname){
        return patientService.getPatientByName(firstname);
    }

    @RequestMapping("/activities/{activityId}/rate")
    public void rateActivity(@PathVariable long activityId, @RequestParam(name = "rating", required = true) int rating) {
        activityRatingService.rateActivity(activityId, rating);
    }
}

