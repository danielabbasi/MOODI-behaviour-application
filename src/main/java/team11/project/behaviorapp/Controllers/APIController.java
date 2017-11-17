package team11.project.behaviorapp.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/patient")
public class APIController {

    @RequestMapping(path = "/activity/create", method = RequestMethod.POST)
    public String createActivity(@RequestParam final String activityName, @RequestParam final String date, @RequestParam final String time) {
        return "Activity Name: " + activityName + "\nDate: " + date + "\nTime: " + time;
    }
}
