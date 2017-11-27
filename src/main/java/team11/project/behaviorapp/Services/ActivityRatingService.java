package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import team11.project.behaviorapp.Repositories.IActivityCreationRepository;
import team11.project.behaviorapp.Repositories.IActivityRatingRepository;

public class ActivityRatingService {

    @Autowired
    public ActivityRatingService(IActivityRatingRepository activityRatingRepository) {
        this.activityRatingRepository = activityRatingRepository;
    }

    private IActivityRatingRepository activityRatingRepository;
}