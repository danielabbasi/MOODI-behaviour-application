package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.CalendarActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1628725 on 05/12/2017.
 */
@Repository
public class ActivityCalendarRepository extends JdbcRepository implements IActivityCalendarRepository {

    public List<CalendarActivity> getActivitiesForCalendar(long patientId, long month, long year) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT activity_ID, activity_name, activity_date, is_completed, (activity_date >= NOW() - INTERVAL 10 MINUTE AND activity_date <= NOW()) AS upcoming, (IF((NOW() >= activity_date = TRUE) AND is_completed = FALSE, TRUE, FALSE)) AS past FROM activities WHERE patient_id = ? AND MONTH(activity_date) = ? AND YEAR(activity_date) = ?;");

            preparedStatement.setLong(1, patientId);
            preparedStatement.setLong(2, month);
            preparedStatement.setLong(3, year);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<CalendarActivity> returnCalendarActivities = new ArrayList<>();

            while(resultSet.next()) {
                returnCalendarActivities.add(new CalendarActivity(resultSet.getLong(1), resultSet.getString(2), resultSet.getTimestamp(3).toLocalDateTime(), resultSet.getBoolean(4), resultSet.getBoolean(5), resultSet.getBoolean(6)));
            }

            return returnCalendarActivities;
        } catch (SQLException exception) {
            return null;
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {

            }
        }
    }
}
