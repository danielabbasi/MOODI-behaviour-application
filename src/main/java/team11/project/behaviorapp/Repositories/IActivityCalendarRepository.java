package team11.project.behaviorapp.Repositories;

import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.CalendarActivity;

import java.util.List;

/**
 * Created by c1628725 on 05/12/2017.
 */
public interface IActivityCalendarRepository {

    List<CalendarActivity> getActivitiesForCalendar(long patientId, long month, long year);
}
