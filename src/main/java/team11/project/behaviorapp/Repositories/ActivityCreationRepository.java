package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;

@Repository
public class ActivityCreationRepository extends JdbcRepository implements IActivityCreationRepository {

    public void createActivity(long patientID, String activityName, Date date) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO activities (activity_name, activity_date, is_completed, rating_before, is_deleted, patient_id, rating_after, is_favourite) VALUES(?, ?, false, null, false, ?, null, null);");

            preparedStatement.setString(1, activityName);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime())); //Don't use 'setDate(...)' here because this will only include the date, not the time.
            preparedStatement.setLong(3, patientID);

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