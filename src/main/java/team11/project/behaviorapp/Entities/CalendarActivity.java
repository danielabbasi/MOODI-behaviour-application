package team11.project.behaviorapp.Entities;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by c1628725 on 05/12/2017.
 */
public class CalendarActivity {

    public CalendarActivity() {
    }

    public CalendarActivity(long activityId, String name, LocalDateTime activityDate, boolean isCompleted, boolean upcoming, boolean past) {
        this.activityId = activityId;
        this.name = name;
        this.activityDate = activityDate;
        this.isCompleted = isCompleted;
        this.upcoming = upcoming;
        this.past = past;
    }

    private long activityId;

    private String name;

    private LocalDateTime activityDate;

    private boolean isCompleted;

    private boolean upcoming;

    private boolean past;

    public long getActivityId() {
        return activityId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getActivityDate() {
        return activityDate;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public boolean getUpcoming() {
        return upcoming;
    }

    public boolean getPast() {
        return past;
    }
}