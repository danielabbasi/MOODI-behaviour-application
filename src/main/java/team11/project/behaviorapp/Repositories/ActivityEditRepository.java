package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by c1443907 on 07/12/2017.
 */
@Repository
public class ActivityEditRepository extends JdbcRepository implements IActivityEditRepository{

    public void editActivity(long activityId, Date date) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET activity_date = ? WHERE activity_ID = ?;");

//            preparedStatement.setString(1, activityName);
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(date.getTime())); //Don't use 'setDate(...)' here because this will only include the date, not the time.
            preparedStatement.setLong(2, activityId);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {

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
