package team11.project.behaviorapp.Controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team11.project.behaviorapp.Entities.Activities;
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

//    <-------- GP ------------>
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
//    <-------- Patient ------------>

    @RequestMapping(path = "/patient/index")
    public String patientIndex() {
        return "patientIndex";
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

    @RequestMapping("/patient/activities/update")
    public String updateActivity(){
        return "updateActivity";
    }

    @RequestMapping("/list/{id}")
    public String findSpecific(@PathVariable Long id, Model model){
        model.addAttribute("activity", activityRepository.findOne(id));
            return "newlist";
    }

    //    <-------- Test ------------>

    @RequestMapping("/patient/test")
    public String tablePatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());

        return "test";
    }

    @RequestMapping("/patient/activities/{id}")
    public String listTableActivitiesll(@PathVariable Long id, Model model){
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        return "patientActivities";
    }


    @RequestMapping("/patient/graph")
    public String lineGraph(){

        return "linegraph";
    }

//    @RequestMapping("/patient/history/form/{id}")
//    public String listTableActivitiesllCompleted(@PathVariable Long id, Model model){
//        model.addAttribute("act", patientService.getUpcomingActivities(id, false));
//        return "test";
 //   }




//    @RequestMapping("/patient/test/test/{id}")
//    public String listTableActivities(@PathVariable Long id, Model model){
////        model.addAttribute("activities", patientService.getUpcomingActivities(id));
//
//        return "test";
//    }




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

