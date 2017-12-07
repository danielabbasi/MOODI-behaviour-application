package team11.project.behaviorapp.Controllers.API.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Repositories.*;
import team11.project.behaviorapp.Services.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by c1628725 on 07/12/2017.
 */
@RestController
@RequestMapping(path = "/api/patient")
public class PatientActivitiesAPI {

    @Autowired
    public PatientActivitiesAPI(PatientService patientService, ActivityCreationService activityCreationService, ActivityService activityService, ActivityRatingService activityRatingService, ActivityDeletionService activityDeletionService, ActivityFavouriteService activityFavouriteService, ActivityUnFavouriteService activityUnFavouriteService, ActivityRatingBeforeService activityRatingBeforeService) {
        this.patientService = patientService;
        this.activityCreationService = activityCreationService;
        this.activityService = activityService;
        this.activityRatingService = activityRatingService;
        this.activityDeletionService = activityDeletionService;
        this.activityFavouriteService = activityFavouriteService;
        this.activityUnFavouriteService = activityUnFavouriteService;
        this.activityRatingBeforeService = activityRatingBeforeService;
    }

    private PatientService patientService;

    private ActivityCreationService activityCreationService;

    private ActivityService activityService;

    private ActivityRatingService activityRatingService;

    private ActivityDeletionService activityDeletionService;

    private ActivityFavouriteService activityFavouriteService;

    private ActivityUnFavouriteService activityUnFavouriteService;

    private ActivityRatingBeforeService activityRatingBeforeService;

    //Done
    @RequestMapping(path = "{id}/activities/create", method = RequestMethod.POST)
    public ModelAndView createActivity(@PathVariable long id, @RequestParam final String activityName, @RequestParam final String date) throws ParseException {
        //Source adapted from https://stackoverflow.com/questions/4496359/how-to-parse-date-string-to-date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        activityCreationService.createActivity(2, activityName, dateFormat.parse(date));

        return new ModelAndView("redirect:/patient/activities/1");
    }

    //not sure
    @RequestMapping(value = "{id}/activities/update", method = RequestMethod.PUT)
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

    //Done
    @RequestMapping(path = "{id}/activities")
    public Collection<CustomList> getActivities(@PathVariable Long id) {

        Collection<CustomList> activities = patientService.getActivityList(id);

        return activities;
    }

    //Done
    @RequestMapping("{id}/activities/{activityId}/rate")
    public void rateActivity(@PathVariable long id, @PathVariable long activityId, @RequestParam(name = "ratingAfter", required = true) int ratingAfter) {
        activityRatingService.rateActivity(activityId, ratingAfter);
    }

    //Done
    @RequestMapping("{id}/activities/{activityId}/before/rate")
    public void rateActivityBefore(@PathVariable long id, @PathVariable long activityId, @RequestParam(name = "ratingBefore", required = true) int ratingBefore) {
        activityRatingBeforeService.rateActivityBefore(activityId, ratingBefore);
    }

    //Done
    @RequestMapping("{id}/activities/{activityId}/delete")
    public void deleteActivity(@PathVariable long id, @PathVariable long activityId) {
        activityDeletionService.deleteActivity(activityId);
    }

    //Done
    @RequestMapping("{id}/activities/{activityId}/favourite")
    public void favouriteActivity(@PathVariable long id, @PathVariable long activityId) {
        activityFavouriteService.favouriteActivity(activityId);
    }

    //Done
    @RequestMapping("{id}/activities/{activityId}/unfavourite")
    public void unFavouriteActivity(@PathVariable long id, @PathVariable long activityId) {
        activityUnFavouriteService.UnFavouriteActivity(activityId);
    }
}