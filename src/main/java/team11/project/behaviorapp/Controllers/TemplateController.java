package team11.project.behaviorapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Services.PatientService;

import java.util.Collection;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Controller
public class TemplateController {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping(path = "/gp/index")
    public String index() {
        return "gpIndex";
    }


    @RequestMapping("/gp/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());

        return "patients";
    }

    @RequestMapping("/patient/activities/create")
    public String createActivity() {
        return "createActivity";
    }

    @RequestMapping("patient/{id}/activityList")
    public String listActivities(@PathVariable Long id, Model model){
        model.addAttribute("activities", patientService.getActivityList(id));

        return "activityList";
    }

}

