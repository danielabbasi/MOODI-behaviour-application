package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityRatingBeforeRepository;
import team11.project.behaviorapp.Repositories.ActivityRatingBeforeRepository;
/**
 * Created by c1673218 on 06/12/2017.
 */
@Service
public class ActivityRatingBeforeService {

   @Autowired
    public ActivityRatingBeforeService(IActivityRatingBeforeRepository activityRatingBeforeRepository){
       this.activityRatingBeforeRepository = activityRatingBeforeRepository;

   }

   private IActivityRatingBeforeRepository activityRatingBeforeRepository;

    public void rateActivityBefore(Long activityId, int rateBefore){
        activityRatingBeforeRepository.rateActivityBefore(activityId, rateBefore);
    }
}
