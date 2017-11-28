package team11.project.behaviorapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

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
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    ActivityCreationService activityCreationService;
    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityRatingService activityRatingService;
    @Autowired
    ActivityDeletionService activityDeletionService;

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

    @RequestMapping("{id}/activities/completed")
    public List<Activities> getCompletedActivities(@PathVariable Long id ) {

        List<Activities> completedActivities = patientService.getUpcomingActivities(id, true);

        return completedActivities;
    }



    @RequestMapping("test/{firstname}")
    public List<Patient> getPatientByName(@PathVariable String firstname){
        return patientService.getPatientByName(firstname);
    }

    @RequestMapping("/activities/{activityId}/rate")
    public void rateActivity(@PathVariable long activityId, @RequestParam(name = "rating", required = true) int rating) {
        activityRatingService.rateActivity(activityId, rating);
    }

    @RequestMapping("activities/{activityId}/delete")
    public void deleteActivity(@PathVariable long activityId) {
        activityDeletionService.deleteActivity(activityId);
    }
}

