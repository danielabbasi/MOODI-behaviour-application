package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by c1443907 on 02/12/2017.
 */

@Repository
public class ActivityUnFavouriteRepository extends JdbcRepository implements IActivityUnFavouriteRepository {

    public void unFavouriteActivity(long activityId) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET is_favourite = FALSE WHERE activity_ID = ?;");

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
