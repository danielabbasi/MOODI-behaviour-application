package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityRatingRepository;

@Service
public class ActivityRatingService {

    @Autowired
    public ActivityRatingService(IActivityRatingRepository activityRatingRepository) {
        this.activityRatingRepository = activityRatingRepository;
    }

    private IActivityRatingRepository activityRatingRepository;

    public void rateActivity(long activityId, int ratingAfter) {
        activityRatingRepository.rateActivity(activityId, ratingAfter);
    }
}