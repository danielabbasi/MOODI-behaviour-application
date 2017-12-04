package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by c1628725 on 04/12/2017.
 */

@Service
public class ActivityCalendarService {

    @Autowired
    public ActivityCalendarService(PatientRepository patientRepository, ActivityRepository activityRepository) {
        this.patientRepository = patientRepository;
        this.activityRepository = activityRepository;
    }

    private PatientRepository patientRepository;

    private ActivityRepository activityRepository;

    public List<Activities> findAllByPatientIdAndDate(long patientId, long month, long year) {
        Patient patient = patientRepository.findById(patientId);

        //List<Activities> returnActivities = activityRepository.findActivitiesByPatientsAndIsCompletedAndIsDeleted(patient, false, false);

        List<Activities> upcomingActivities = activityRepository.findActivitiesByPatientsAndIsCompletedAndIsDeleted(patient, false, false).stream().filter(a -> Month.valueOf(a.getActivityDate().getMonth().name()).getValue() == month && a.getActivityDate().getYear() == year).collect(Collectors.toList());
        List<Activities> pastActivities = activityRepository.findActivitiesByPatientsAndIsCompletedAndIsDeleted(patient, true, false);

        List<Activities> returnList = new ArrayList<Activities>(upcomingActivities);
        returnList.addAll(pastActivities);

        return returnList;
    }
}
