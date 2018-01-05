package team11.project.behaviorapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.CustomList;
import team11.project.behaviorapp.Repositories.PatientRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ActivityRepository activityRepository;

    public List<Patient>getAllPatients(){
        return patientRepository.findAll();
    }

    public Collection<CustomList>getActivityList(Long id) {

        Patient p = patientRepository.findById(id);

        Collection<CustomList> activities = activityRepository.findActivitiesByPatients(p);

        return activities;
    }

    public List<Activities> getUpcomingActivities(Long id, Boolean isCompleted, Boolean isDeleted) {

        Patient p = patientRepository.findById(id);

        List<Activities> upcomingActivities = activityRepository.findActivitiesByPatientsAndIsCompletedAndIsDeleted(p, isCompleted, isDeleted);

        return upcomingActivities;
    }

    public List<Activities> getCompletedActivities(Long id, Boolean isCompleted) {

        Patient p = patientRepository.findById(id);

        List<Activities> completedActivities = activityRepository.findActivitiesByPatientsAndIsCompletedOrderByActivityDateAsc(p, isCompleted);

        return completedActivities;
    }

    public List<Activities> lastActivitiesOfPatient(Long id, Boolean isCompleted) {

        Patient p = patientRepository.findById(id);

        List<Activities> lastActivities = activityRepository.findFirst3ActivitiesByPatientsAndIsCompletedOrderByActivityDateDesc(p, isCompleted);

        return lastActivities;
    }


    public List<Activities> getFavouritedActivities(Long id, Boolean isFavourite,Boolean isDeleted) {

        Patient p = patientRepository.findById(id);

        List<Activities> favouriteActivities = activityRepository.findActivitiesByPatientsAndIsFavouriteAndIsDeleted(p, isFavourite, isDeleted);

        return favouriteActivities;
    }

    public List<Activities> getActivitiesByDay(Long id) {

        Patient p = patientRepository.findById(id);

        List<Activities> activitiesByDay = activityRepository.getActivitiesByPatientsAndActivityDate_DayOfWeek(p);

        return activitiesByDay;
    }



    public Patient getSpecificRecord(@PathVariable Long id){
        return patientRepository.findOne(id);
    }

    public Patient getPatientFirstLastName(@PathVariable Long id){
        return patientRepository.findOne(id);
    }

    public List<Patient> getPatientByName(@PathVariable String firstname){
        return patientRepository.findPatientByFirstname(firstname);
    }

    public List<Activities> getActivitiesByBeforeAndAfter(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        List<Activities> activitiesBeforeAfter = activityRepository.getActivitiesByPatientsAndRatingAfterAndRatingBefore(p);

        return activitiesBeforeAfter;

    }

    public int getActivitiesByName(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int countCompletedActivities = activityRepository.getActivitiesByName(p);

        return countCompletedActivities;

    }

    public int getActivitiesByRatingAfter(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int avgRatingAfter = activityRepository.getActivitiesByRatingAfter(p);

        return avgRatingAfter;
    }

    public int getActivitiesByNameAndIsDeleted(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int total = activityRepository.getActivitiesByNameAndIsDeleted(p);

        return total;
    }

    public int getActivitiesByNameAndIsDeletedAndIsCompleted(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int upcomingActivities = activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted(p);

        return upcomingActivities;
    }

    public int getActivitiesByNameAndIsFavourite(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int countFavoritedActivities = activityRepository.getActivitiesByNameAndIsFavourite(p);

        return countFavoritedActivities;
    }

    // This will be used to list activities that have provided the highest positive mood change (for the GP states)

    public List<Activities> getActivitiesByHighestPositiveMoodChange(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        List<Activities> positiveMoodChangeActivities = activityRepository.findFirstByActivitiesByHighestPositiveMoodChange(p);

        return positiveMoodChangeActivities;
    }
    // This will be used to list activities that have provided the highest negative mood change (for the GP states)

    public List<Activities> getActivitiesByHighestNegativeMoodChange(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        List<Activities> negativeMoodChangeActivities = activityRepository.findFirstByActivitiesByHighestNegativeMoodChange(p);

        return negativeMoodChangeActivities;
    }

    public int countActivitiesByHighestPositiveMoodChange(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int countPositiveActivities = activityRepository.countActivitiesByHighestPositiveMoodChange(p);

        return countPositiveActivities;
    }

    public int countActivitiesByHighestNegativeMoodChange(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int countNegativeActivities = activityRepository.countActivitiesByHighestNegativeMoodChange(p);

        return countNegativeActivities;
    }

    public int getActivitiesByIsDeleted(@PathVariable Long id){

        Patient p = patientRepository.findById(id);

        int countDeletedActivities = activityRepository.getActivitiesByIsDeleted(p);

        return countDeletedActivities;
    }

    public List<Activities> differenceGraph(@PathVariable Long id){
        Patient p = patientRepository.findById(id);

        List <Activities> differenceActivities = activityRepository.findByDifferenceAndName(p);

        return differenceActivities;
    }

    public List<Activities> getActivitiesByPatientsAndIsDeleted(Long id, Boolean isDeleted) {

        Patient p = patientRepository.findById(id);

        List<Activities> deletedActivities = activityRepository.findActivitiesByPatientsAndIsDeleted(p, isDeleted);

        return deletedActivities;
    }




}
