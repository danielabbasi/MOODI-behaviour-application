package team11.project.behaviorapp.Repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;

import java.awt.print.Pageable;
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
    List<Activities> findActivitiesByActivityDateEquals(LocalDateTime aMoment);
    List<Activities>findActivitiesByPatientsAndIsFavouriteAndIsDeleted(Patient p, Boolean isFavourite, Boolean isDeleted);
    List<Activities> findFirst3ActivitiesByPatientsAndIsCompletedOrderByActivityDateDesc(Patient p, Boolean isCompleted);
    List<Activities> findActivitiesByActivityDateEqualsAndIsCompletedAndIsDeleted(LocalDateTime aMoment, Boolean isCompleted, Boolean isDeleted);

    List<Activities> findActivitiesByIsCompleted(Boolean isCompleted);
    Collection<CustomList> findActivitiesByIsDeleted(Boolean x);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isCompleted = 1 AND patients=?1")
    int getActivitiesByName(Patient p);

    @Query(value = "SELECT AVG(ratingAfter) FROM Activities WHERE patients=?1")
    int getActivitiesByRatingAfter(Patient p);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isDeleted = 0 AND patients=?1")
    int getActivitiesByNameAndIsDeleted(Patient p);

    @Query(value = "SELECT COUNT(name) FROM Activities  WHERE isDeleted = 0 AND isCompleted = 0 AND patients=?1")
    int getActivitiesByNameAndIsDeletedAndIsCompleted(Patient p);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isFavourite = 1 AND patients=?1")
    int getActivitiesByNameAndIsFavourite(Patient p);

    @Query(value = "SELECT activityDate FROM Activities WHERE id = 1")
    LocalDateTime getActivitiesByActivityDate();

    @Query(value = "SELECT COUNT(activityDate), function('DAYNAME', activityDate), function('DAYOFWEEK', activityDate) AS days FROM Activities WHERE patients =?1 GROUP BY(function('DAYNAME', activityDate) ) ORDER BY days ASC ")
    List <Activities> getActivitiesByPatientsAndActivityDate_DayOfWeek(Patient p);

    @Query(value = "SELECT name FROM Activities WHERE patients=?1 AND ratingAfter-ratingBefore= (SELECT function('MAX',ratingAfter-ratingBefore) FROM Activities ) ")
    List <Activities> queryFirstByActivitiesByHighestPositiveMoodChange(Patient p);


    @Query(value = "SELECT name FROM Activities WHERE patients=?1 AND ratingAfter-ratingBefore= (SELECT function('MIN',ratingAfter-ratingBefore) FROM Activities )")
    List <Activities> queryFirstByActivitiesByHighestNegativeMoodChange(Patient p);

    @Query(value = "SELECT function('ROUND', AVG(ratingBefore)), function('ROUND', AVG(ratingAfter)) FROM Activities WHERE patients=?1")
    List<Activities> getActivitiesByPatientsAndRatingAfterAndRatingBefore(Patient p);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isDeleted = 1 AND patients=?1")
    int getActivitiesByIsDeleted(Patient p);









}
