package team11.project.behaviorapp.Controllers.Prototypes;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @RequestMapping("/new/{id}/index")
    public String newIndexPatient(@PathVariable Long id, Model model) {

        String topBarTitleForIndex = "Dashboard";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        model.addAttribute("activities", patientService.getActivityList(id));

        double numCompleted = patientService.getActivitiesByName(id);
        double total = patientService.getActivitiesByNameAndIsDeleted(id);
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("topBarTitle", topBarTitleForIndex);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", patientService.getActivitiesByNameAndIsFavourite(id));
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", patientService.getActivitiesByRatingAfter(id));
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));
        model.addAttribute("positiveActivity", patientService.getActivitiesByHighestPositiveMoodChange(id));
        model.addAttribute("negativeActivity", patientService.getActivitiesByHighestNegativeMoodChange(id));
        model.addAttribute("totalDeleted", patientService.getActivitiesByIsDeleted(id));



        return "newPatientIndex";
    }

    @RequestMapping("/new/{id}/activities")
    public String graph(@PathVariable Long id, Model model){
        String topBarTitleForIndex = "Activities";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        model.addAttribute("activities", patientService.getActivityList(id));

        double numCompleted = patientService.getActivitiesByName(id);
        double total = patientService.getActivitiesByNameAndIsDeleted(id);
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("topBarTitle", topBarTitleForIndex);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", patientService.getActivitiesByNameAndIsFavourite(id));
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", patientService.getActivitiesByRatingAfter(id));
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));
        model.addAttribute("positiveActivity", patientService.getActivitiesByHighestPositiveMoodChange(id));
        model.addAttribute("negativeActivity", patientService.getActivitiesByHighestNegativeMoodChange(id));
        model.addAttribute("totalDeleted", patientService.getActivitiesByIsDeleted(id));


        return "newPatientActivities";
    }

    @RequestMapping("/new/{id}/accord")
    public String accord(@PathVariable Long id, Model model){
        String topBarTitleForIndex = "Activities";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        model.addAttribute("activities", patientService.getActivityList(id));

        double numCompleted = patientService.getActivitiesByName(id);
        double total = patientService.getActivitiesByNameAndIsDeleted(id);
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("topBarTitle", topBarTitleForIndex);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", patientService.getActivitiesByNameAndIsFavourite(id));
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", patientService.getActivitiesByRatingAfter(id));
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));
        model.addAttribute("positiveActivity", patientService.getActivitiesByHighestPositiveMoodChange(id));
        model.addAttribute("negativeActivity", patientService.getActivitiesByHighestNegativeMoodChange(id));
        model.addAttribute("totalDeleted", patientService.getActivitiesByIsDeleted(id));


        return "accordianTest";
    }


    @RequestMapping("/patient/graph")
    public String lineGraph(){

        return "tabtester";
    }


//   <---------- Statistics ------------>


    @RequestMapping("/patient/stats/template")
    public String statTemplate(Model model, Long id){
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", patientService.getActivitiesByRatingAfter(id));
        model.addAttribute("totalCreated", patientService.getActivitiesByNameAndIsDeleted(id));
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));





        return "statsTest";
    }


    @RequestMapping("/new/{id}/calendar")
    public String getCalendar(@PathVariable long id, Model model) {
        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
        return "calendar";
    }




}
