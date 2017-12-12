package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Adapted and edited from the deletion/rating repositories
@Repository
public class ActivityFavouriteRepository extends JdbcRepository implements IActivityFavouriteRepository {

    public void favouriteActivity(long activityId) {
        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE activities SET is_favourite = TRUE WHERE activity_ID = ?;");

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
