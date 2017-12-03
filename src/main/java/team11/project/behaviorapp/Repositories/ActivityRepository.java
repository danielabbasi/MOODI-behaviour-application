package team11.project.behaviorapp.Repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activities, Long>{

    List<Activities> findAll();
//    List<Activities> findActivitiesById(Long id);

//    Collection<CustomList>findActivitiesById(Long id);
    Collection<CustomList> findActivitiesByPatients(Patient p);
    List<Activities> findActivitiesByPatientsAndIsCompletedAndIsDeleted(Patient p, Boolean isCompleted, Boolean isDeleted);
    List<Activities> findActivitiesByPatientsAndIsCompletedOrderByActivityDateAsc(Patient p, Boolean isCompleted);
    List<Activities>findActivitiesByPatientsAndIsFavouriteAndIsDeleted(Patient p, Boolean isFavourite, Boolean isDeleted);
    List<Activities> findFirst3ActivitiesByPatientsAndIsCompletedOrderByActivityDateDesc(Patient p, Boolean isCompleted);

    List<Activities> findActivitiesByIsCompleted(Boolean isCompleted);
    Collection<CustomList> findActivitiesByIsDeleted(Boolean x);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isCompleted = 1")
    int getActivitiesByName();

    @Query(value = "SELECT AVG(ratingAfter) FROM Activities")
    int getActivitiesByRatingAfter();

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isDeleted = 0")
    int getActivitiesByNameAndIsDeleted();

    @Query(value = "SELECT COUNT(name) FROM Activities  WHERE isDeleted = 0 AND isCompleted = 0")
    int getActivitiesByNameAndIsDeletedAndIsCompleted();

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isFavourite = 1")
    int getActivitiesByNameAndIsFavourite();

    @Query(value = "SELECT activityDate FROM Activities WHERE id = 1")
    LocalDateTime getActivitiesByActivityDate();



}
