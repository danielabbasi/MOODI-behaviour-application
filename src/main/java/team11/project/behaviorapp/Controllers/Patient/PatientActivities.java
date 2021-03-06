package team11.project.behaviorapp.Controllers.Patient;

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
public class PatientActivities {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;




    @RequestMapping("/patient/sidemenu")
    public String sideMenuView(Model model, Long id){
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));

        return "patientSideMenu";
    }

    @RequestMapping("/patient/activities/{id}")
    public String listTableActivitiesll(@PathVariable Long id, Model model){

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        String topBarTitleForActivities = "Activities";

        double numCompleted = patientService.getActivitiesByName(id);
        double total = patientService.getActivitiesByNameAndIsDeleted(id);
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("date", activityRepository.getActivitiesByActivityDate());
        model.addAttribute("favouriteCount", patientService.getActivitiesByNameAndIsFavourite(id));
        model.addAttribute("topBarTitle", topBarTitleForActivities);
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", patientService.getActivitiesByName(id));
        model.addAttribute("avgRating", patientService.getActivitiesByRatingAfter(id));
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", patientService.getActivitiesByNameAndIsDeletedAndIsCompleted(id));


        return "newPatientActivities";
    }



    @RequestMapping("/patient/activities/{id}/calendar")
    public String getCalendar(@PathVariable long id, Model model) {
        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
        return "calendar";
    }





}
