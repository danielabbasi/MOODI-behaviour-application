package team11.project.behaviorapp.Controllers.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.CalendarActivity;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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
    @Autowired
    ActivityFavouriteService activityFavouriteService;
    @Autowired
    ActivityUnFavouriteService activityUnFavouriteService;
    @Autowired
    ActivityCalendarService activityCalendarService;

    @RequestMapping(path = "/activities/create", method = RequestMethod.POST)
    public ModelAndView createActivity(@RequestParam final String activityName, @RequestParam final String date) throws ParseException {
        //Source adapted from https://stackoverflow.com/questions/4496359/how-to-parse-date-string-to-date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        activityCreationService.createActivity(1, activityName, dateFormat.parse(date));

        return new ModelAndView("redirect:/patient/activities/1");
    }

    @RequestMapping(value = "/one/update", method = RequestMethod.PUT)
    public ModelAndView updateOneActivity(@RequestParam  String name, @RequestParam String date)throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        Activities activities = new Activities();
        activities.setId(1L);
        activities.setName(name);
        activities.setActivityDate(LocalDateTime.parse(date));
        activities.setCompleted(false);
        activities.setDeleted(false);
        activities.setFavourite(false);
        activities.setRatingBefore(null);
        activities.setRatingAfter(null);
        activityService.saveActivity(activities);
        return new ModelAndView("redirect:/patient/activities/1");
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

        List<Activities> completedActivities = patientService.getCompletedActivities(id, true);

        return completedActivities;
    }

    @RequestMapping("{id}/activities/patient/index")
    public List<Activities> getPatientsLastActivities(@PathVariable Long id ) {

        List<Activities> completedActivities = patientService.lastActivitiesOfPatient(id, true);

        return completedActivities;
    }



    @RequestMapping("{id}/activities/days")
    public List<Activities> getActivitiesByDays(@PathVariable Long id){

        List <Activities> activitiesByDays = patientService.getActivitiesByDay(id);

        return activitiesByDays;

    }




    @RequestMapping("test/{firstname}")
    public List<Patient> getPatientByName(@PathVariable String firstname){
        return patientService.getPatientByName(firstname);
    }

    @RequestMapping("/activities/{activityId}/rate")
    public void rateActivity(@PathVariable long activityId, @RequestParam(name = "ratingAfter", required = true) int ratingAfter) {
        activityRatingService.rateActivity(activityId, ratingAfter);
    }

    @RequestMapping("activities/{activityId}/delete")
    public void deleteActivity(@PathVariable long activityId) {
        activityDeletionService.deleteActivity(activityId);
    }

    @RequestMapping("activities/{activityId}/favourite")
    public void favouriteActivity(@PathVariable long activityId) {
        activityFavouriteService.favouriteActivity(activityId);
    }

    @RequestMapping("activities/{activityId}/unfavourite")
    public void unFavouriteActivity(@PathVariable long activityId) {
        activityUnFavouriteService.UnFavouriteActivity(activityId);
    }

    @RequestMapping("activities/testing")
    public List<Activities> getActivitiesByRatingBeforeAndRatingAfter() {
        return activityRepository.getActivitiesByRatingBeforeAndRatingAfter();
    }



    @RequestMapping("{id}/activities/calendar")
    public List<CalendarActivity> getActivitiesForCalendar(@PathVariable long id, @RequestParam(name = "month", required = true) long month, @RequestParam(name = "year", required = true) long year){
        return activityCalendarService.findAllByPatientIdAndDate(id, month, year);
    }

    @RequestMapping("{id}/activities/average/before/after")
    public List<Activities> activitiesBeforeAfter(@PathVariable Long id){

        return patientService.getActivitiesByBeforeAndAfter(id);
    }


}


