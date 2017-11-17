package team11.project.behaviorapp.Repositories;

import java.sql.*;
import java.util.Date;

public class ActivityCreationRepository implements IActivityCreationRepository {

    public void createActivity(long patientID, String activityName, Date date) {
        Connection connection = null;

//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/donations", "root", "comsc");
//
//            PreparedStatement preparedStatement = connection.prepareStatement("");
//
//            preparedStatement.setString(1, charityRegistrationNumber);
//            preparedStatement.setString(2, charityRegistrationNumber);
//            preparedStatement.setInt(3, count);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                returnCharityActivities.add(new CharityActivity(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3)));
//            }
//        } catch (SQLException exception) {
//
//        } finally {
//            try {
//                if(connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException exception) {
//
//            }
//        }
    }
}
