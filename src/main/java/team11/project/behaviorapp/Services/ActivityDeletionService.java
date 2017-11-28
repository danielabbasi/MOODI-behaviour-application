package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityDeletionRepository;
import team11.project.behaviorapp.Repositories.IActivityRatingRepository;

/**
 * Created by c1673239 on 28/11/2017.
 */
@Service
public class ActivityDeletionService {
    @Autowired
    public ActivityDeletionService(IActivityDeletionRepository activityDeletionRepository) {
        this.activityDeletionRepository = activityDeletionRepository;
    }

    private IActivityDeletionRepository activityDeletionRepository;

    public void deleteActivity(long activityId) {
        activityDeletionRepository.deleteActivity(activityId);
    }


}
