package team11.project.behaviorapp.Repositories;

/**
 * Created by c1673239 on 28/11/2017.
 */
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ActivityDeletionRepository extends JdbcRepository implements IActivityDeletionRepository {

    public void deleteActivity(long activityId) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET is_deleted = TRUE WHERE activity_ID = ?;");

            preparedStatement.setLong(1, activityId);

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
