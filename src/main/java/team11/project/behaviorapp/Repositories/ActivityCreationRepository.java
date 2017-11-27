package team11.project.behaviorapp.Repositories;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;

@Repository
public class ActivityCreationRepository extends JdbcRepository implements IActivityCreationRepository {

    public void createActivity(long patientID, String activityName, Date date) {

    }
}
