package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityUnFavouriteRepository;

/**
 * Created by c1443907 on 02/12/2017.
 */

@Service
public class ActivityUnFavouriteService {

    @Autowired
    public ActivityUnFavouriteService(IActivityUnFavouriteRepository activityUnFavouriteRepository){
        this.activityUnFavouriteRepository = activityUnFavouriteRepository;

    }

    private IActivityUnFavouriteRepository activityUnFavouriteRepository;

    public void UnFavouriteActivity(Long activityId){
        activityUnFavouriteRepository.unFavouriteActivity(activityId);
    }
}
