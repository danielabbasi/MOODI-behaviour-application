package team11.project.behaviorapp.Controllers.Patient;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * Created by c1673218 on 04/12/2017.
 */
public class ActivityNotifer {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting() throws Exception {
        Thread.sleep(1000); // simulated delay
        return "*";
    }
}
