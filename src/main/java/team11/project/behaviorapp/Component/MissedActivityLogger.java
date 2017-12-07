package team11.project.behaviorapp.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Repositories.ActivityRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by c1443907 on 07/12/2017.
 */

@Component
public class MissedActivityLogger {

    private ActivityRepository activityRepository;
    private SimpMessagingTemplate template;


    @Autowired
    public MissedActivityLogger(ActivityRepository aRepo, SimpMessagingTemplate aTemplate) {
        activityRepository = aRepo;
        template = aTemplate;
    }

    @Scheduled(
            cron = "0 0/1 * * * *")
    @Transactional
    public void logActivityReminder(){
        LocalDateTime missed = LocalDateTime.now().minus(2, ChronoUnit.HOURS).withNano(0).withSecond(0);



        System.out.println("Activities at " + missed.withNano(0).withSecond(0));
        for (Activities a : activityRepository.findActivitiesByActivityDateEqualsAndIsCompletedAndIsDeleted(missed, false, false)) {


            System.out.println(a.getName());


            template.convertAndSend("/topic/missed", a.getId());

        }


    }
}
