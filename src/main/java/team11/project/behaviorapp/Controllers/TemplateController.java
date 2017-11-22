package team11.project.behaviorapp.Controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.PatientService;

import javax.persistence.EntityResult;
import javax.servlet.http.HttpSession;
import java.util.Collection;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Controller
public class TemplateController {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(path = "/gp/index")
    public String index() {
        return "gpIndex";
    }


    @RequestMapping("/gp/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());

        return "patientsList";
    }

    @RequestMapping("/gp/patients/record/{id}")
    public String specificRecord(@PathVariable Long id, Model model){
        model.addAttribute("records", patientService.getSpecificRecord(id));
        return "patientRecord";
    }

    @RequestMapping("/patient/activities/create")
    public String createActivity() {
        return "createActivity";
    }

    @RequestMapping("/patient/{id}/activityList")
    public String listActivities(@PathVariable Long id, Model model){
        model.addAttribute("activities", patientService.getActivityList(id));
        return "activityList";
    }

//    @RequestMapping("/login")
//    public String login(HttpSession httpSession, @RequestParam("username") String username, @RequestParam("password") String password){
//        Account a = accountSrvice.authnticate(username, password);
//
//        if (a != null) httpSession.setAttribute("account", a);
//        else return null;
////        model.addAttribute("activities", patientService.getActivityList(id));
//
//        return "activityList";
//    }



}

