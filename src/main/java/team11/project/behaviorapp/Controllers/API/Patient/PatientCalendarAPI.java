package team11.project.behaviorapp.Controllers.API.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team11.project.behaviorapp.Entities.CalendarActivity;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

import java.util.List;

/**
 * Created by c1628725 on 07/12/2017.
 */
@RestController
@RequestMapping(path = "/api/patient")
public class PatientCalendarAPI {

    @Autowired
    public PatientCalendarAPI(ActivityCalendarService activityCalendarService) {
        this.activityCalendarService = activityCalendarService;
    }

    private ActivityCalendarService activityCalendarService;

    //Done
    @RequestMapping("{id}/activities/calendar")
    public List<CalendarActivity> getActivitiesForCalendar(@PathVariable long id, @RequestParam(name = "month", required = true) long month, @RequestParam(name = "year", required = true) long year){
        return activityCalendarService.findAllByPatientIdAndDate(id, month, year);
    }
}
