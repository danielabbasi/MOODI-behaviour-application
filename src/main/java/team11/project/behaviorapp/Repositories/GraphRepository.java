package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;
import team11.project.behaviorapp.Entities.abc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by c1443907 on 04/12/2017.
 */

@Repository
public class GraphRepository extends JdbcRepository {

    public abc graph(){

        Connection connection = null;

        try {
            connection = getDatabaseConnection();

            PreparedStatement preparedStatement = connection.prepareStatement( "SELECT Count(activity_name)FROM activities WHERE is_deleted = false ");



            abc value = new abc();

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                value.setCount(resultSet.getInt(1));
            }

            return value;

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
