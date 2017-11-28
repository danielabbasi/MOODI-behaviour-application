package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ActivityRatingRepository extends JdbcRepository implements IActivityRatingRepository {

    public void rateActivity(long activityId, int rating) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET rating = ?, is_completed = true WHERE activity_id = ?;");

            preparedStatement.setInt(1, rating);
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