package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Repositories.IActivityEditRepository;

import java.util.Date;

/**
 * Created by c1443907 on 07/12/2017.
 */

@Service
public class ActivityEditService {

    @Autowired
    public ActivityEditService(IActivityEditRepository activityEditRepository){
        this.activityEditRepository = activityEditRepository;

    }


    private IActivityEditRepository activityEditRepository;

    public void editActivity(long activityId, Date date){
        activityEditRepository.editActivity(activityId, date);
    }
}
