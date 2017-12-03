package team11.project.behaviorapp.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Repositories.ActivityRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by c1673218 on 03/12/2017.
 */
@Component
public class ActivityLogger {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityLogger(ActivityRepository aRepo) {
        activityRepository = aRepo;
    }

    @Scheduled(fixedRate = 30000)
    @Transactional
    public void logActivityReminder(){
        LocalDateTime start = LocalDateTime.now().minus(10, ChronoUnit.MINUTES);
        LocalDateTime finish = LocalDateTime.now();

        System.out.println("Activities between " + start + " and " + finish );
        for (Activities a : activityRepository.findByActivityDateBetween(start, finish) ){
            System.out.println(a.getName());
        }
    }

}
