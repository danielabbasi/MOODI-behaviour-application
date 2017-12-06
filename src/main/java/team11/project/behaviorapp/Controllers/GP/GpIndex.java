package team11.project.behaviorapp.Controllers.GP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.PatientService;

/**
 * Created by c1443907 on 04/12/2017.
 */

@Controller
public class GpIndex {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;


    @RequestMapping(path = "/gp/index")
    public String index( Model model) {
        String topBarTitleForGpIndex = "Dashboard";



        model.addAttribute("topBarTitle", topBarTitleForGpIndex);

        return "gpIndex";
    }



}
