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
public class GpPatients {

    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;

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

    @RequestMapping("/patient/{id}/activityList")
    public String listActivities(@PathVariable Long id, Model model){

        String topBarForGpPatientActivities = "Activities For ";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));
        model.addAttribute("topBarTitle", topBarForGpPatientActivities);
        model.addAttribute("activities", patientService.getActivityList(id));
        return "activityList";
    }
}
