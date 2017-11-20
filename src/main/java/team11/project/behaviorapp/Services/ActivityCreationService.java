package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.IActivityCreationRepository;

import java.util.Date;

@Service
public class ActivityCreationService {

    @Autowired
    public ActivityCreationService(IActivityCreationRepository activityCreationRepository) {
        this.activityCreationRepository = activityCreationRepository;
    }

    private IActivityCreationRepository activityCreationRepository;

    public void createActivity(long patientID, String activityName, Date date) {
        activityCreationRepository.createActivity(patientID, activityName, date);
    }
}
