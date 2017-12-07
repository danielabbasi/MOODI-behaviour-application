package team11.project.behaviorapp.Controllers.Prototypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.PatientService;

/**
 * Created by c1443907 on 04/12/2017.
 */

@Controller
public class TestController {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;


    @RequestMapping("/patient/test")
    public String tablePatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());

        return "test";
    }

    @RequestMapping("/patient/graph")
    public String lineGraph(){

        return "linegraph";
    }


//   <---------- Statistics ------------>


    @RequestMapping("/patient/stats/template")
    public String statTemplate(Model model, Long id){
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", activityRepository.getActivitiesByRatingAfter());
        model.addAttribute("totalCreated", activityRepository.getActivitiesByNameAndIsDeleted());
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());





        return "statsTest";
    }

}
