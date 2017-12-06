package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityFavouriteRepository;

@Service
public class ActivityFavouriteService {

    @Autowired
    public ActivityFavouriteService(IActivityFavouriteRepository activityFavouriteRepository){
        this.activityFavouriteRepository = activityFavouriteRepository;

    }

    private IActivityFavouriteRepository activityFavouriteRepository;

    public void favouriteActivity(long activityId){
        activityFavouriteRepository.favouriteActivity(activityId);
    }



}
