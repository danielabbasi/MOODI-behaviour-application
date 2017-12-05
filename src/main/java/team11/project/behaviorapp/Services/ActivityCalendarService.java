package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.CalendarActivity;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.IActivityCalendarRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by c1628725 on 04/12/2017.
 */

@Service
public class ActivityCalendarService {

    @Autowired
    public ActivityCalendarService(IActivityCalendarRepository activityCalendarRepository) {
        this.activityCalendarRepository = activityCalendarRepository;
    }

    private IActivityCalendarRepository activityCalendarRepository;

    public List<CalendarActivity> findAllByPatientIdAndDate(long patientId, long month, long year) {
        List<CalendarActivity>  a = activityCalendarRepository.getActivitiesForCalendar(patientId, month, year);
        System.out.println(a.size());
        return a;
    }
}
