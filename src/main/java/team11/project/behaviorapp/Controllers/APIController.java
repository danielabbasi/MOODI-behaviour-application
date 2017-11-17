package team11.project.behaviorapp.Controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class APIController {

    @RequestMapping(path = "/activity/create", method = RequestMethod.POST)
    public String createActivity(@RequestBody final String activityName, @RequestBody final String date, @RequestBody final String time) {
        return "Activity Name: " + activityName + "\nDate: " + date + "\nTime: " + time;
    }
}
