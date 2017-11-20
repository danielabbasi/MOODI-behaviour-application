package team11.project.behaviorapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import team11.project.behaviorapp.Services.PatientService;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Controller
public class TemplateController {

    @Autowired
    PatientService patientService;

    @RequestMapping(path = "/gp/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/gp/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());

        return "patients";
    }



}