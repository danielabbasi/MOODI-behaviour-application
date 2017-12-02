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
    public String index( Model model) {
        String topBarTitleForGpIndex = "Dashboard";



        model.addAttribute("topBarTitle", topBarTitleForGpIndex);

        return "gpIndex";
    }


    @RequestMapping("/gp/patients")
    public String listPatients(Model model) {

        String topBarTitleForGpPatientList = "List of Patients";

        model.addAttribute("topBarTitle", topBarTitleForGpPatientList);
        model.addAttribute("patients", patientService.getAllPatients());

        return "patientsList";
    }

    @RequestMapping("/gp/patients/record/{id}")
    public String specificRecord(@PathVariable Long id, Model model){

        String topBarTitleForGpRecords = "Record For ";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
        model.addAttribute("topBarTitle", topBarTitleForGpRecords);
        model.addAttribute("records", patientService.getSpecificRecord(id));
        return "patientRecord";
    }
//    <-------- Patient ------------>

//    @RequestMapping(path = "/patient/{id}/topbar")
//    public String patientTopBar(@PathVariable Long id, Model model){
//        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
//        return "header";
//    }

    @RequestMapping(path = "/patient/{id}/index")
    public String patientIndex(@PathVariable Long id, Model model) {

        String topBarTitleForIndex = "Dashboard";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        model.addAttribute("activities", patientService.getActivityList(id));

        double numCompleted = activityRepository.getActivitiesByName();
        double total = activityRepository.getActivitiesByNameAndIsDeleted();
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("topBarTitle", topBarTitleForIndex);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", activityRepository.getActivitiesByNameAndIsFavourite());
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", activityRepository.getActivitiesByName());
        model.addAttribute("avgRating", activityRepository.getActivitiesByRatingAfter());
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());


        return "patientIndex";
    }

    @RequestMapping("/patient/activities/create")
    public String createActivity() {
        return "createActivity";
    }

    @RequestMapping("/patient/{id}/activityList")
    public String listActivities(@PathVariable Long id, Model model){

        String topBarForGpPatientActivities = "Activities For ";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
        model.addAttribute("topBarTitle", topBarForGpPatientActivities);
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

    @RequestMapping("/patient/sidemenu")
    public String sideMenuView(Model model){
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());

        return "patientSideMenu";
    }

    @RequestMapping("/patient/activities/{id}")
    public String listTableActivitiesll(@PathVariable Long id, Model model){

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        String topBarTitleForActivities = "Activities";

        double numCompleted = activityRepository.getActivitiesByName();
        double total = activityRepository.getActivitiesByNameAndIsDeleted();
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", activityRepository.getActivitiesByNameAndIsFavourite());
        model.addAttribute("topBarTitle", topBarTitleForActivities);
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", activityRepository.getActivitiesByName());
        model.addAttribute("avgRating", activityRepository.getActivitiesByRatingAfter());
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());


        return "patientActivities";
    }

    //    <-------- Test ------------>

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
    public String statTemplate(Model model){
        model.addAttribute("completedCount", activityRepository.getActivitiesByName());
        model.addAttribute("avgRating", activityRepository.getActivitiesByRatingAfter());
        model.addAttribute("totalCreated", activityRepository.getActivitiesByNameAndIsDeleted());
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());





        return "statsTest";
    }




}

