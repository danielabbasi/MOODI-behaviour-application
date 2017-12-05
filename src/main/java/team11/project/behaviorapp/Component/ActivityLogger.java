package team11.project.behaviorapp.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Repositories.ActivityRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Scheduled(
            cron = "0 0/1 * * * *")
    @Transactional
    public void logActivityReminder(){
        LocalDateTime start = LocalDateTime.now().plus(10, ChronoUnit.MINUTES).withNano(0).withSecond(0);


        System.out.println("Activities at " + start.withNano(0).withSecond(0));
        for (Activities a : activityRepository.findActivitiesByActivityDateEquals(start)) {


            System.out.println(a.getName());


            template.convertAndSend("/topic/greetings", a.getName());

        }
    }

}
