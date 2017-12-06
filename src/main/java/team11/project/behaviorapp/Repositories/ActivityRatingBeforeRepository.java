package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by c1673218 on 06/12/2017.
 */
@Repository
public class ActivityRatingBeforeRepository extends JdbcRepository implements IActivityRatingBeforeRepository {

    public void rateActivityBefore(long activityId, int ratingBefore) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET rating_before = ? WHERE activity_id = ?;");

            preparedStatement.setInt(1, ratingBefore);
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

