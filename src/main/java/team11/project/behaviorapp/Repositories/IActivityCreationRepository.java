package team11.project.behaviorapp.Repositories;

import java.util.Date;

/**
 * Created by c1628725 on 17/11/2017.
 */
public interface IActivityCreationRepository {
    void createActivity(long patientID, String activityName, Date date);
}
