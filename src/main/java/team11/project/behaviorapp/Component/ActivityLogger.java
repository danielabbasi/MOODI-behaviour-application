package team11.project.behaviorapp.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    private SimpMessagingTemplate template;


    @Autowired
    public ActivityLogger(ActivityRepository aRepo, SimpMessagingTemplate aTemplate) {
        activityRepository = aRepo;
        template = aTemplate;
    }

    @Scheduled(fixedRate = 10000)
    @Transactional
    public void logActivityReminder(){
        LocalDateTime start = LocalDateTime.now().minus(10, ChronoUnit.MINUTES);
        LocalDateTime finish = LocalDateTime.now();

        System.out.println("Activities between " + start + " and " + finish );
//        template.convertAndSend("/topic/greetings" );
        for (Activities a : activityRepository.findByActivityDateBetween(start, finish) ){
            System.out.println(a.getName());
            if (activityRepository.findByActivityDateBetween(start, finish) != null  ){
                template.convertAndSend("/topic/greetings", a.getName());
                break;
            }
            break;

        }
    }

}
