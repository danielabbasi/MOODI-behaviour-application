package team11.project.behaviorapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;

import java.util.Collection;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activities, Long>{

    List<Activities> findAll();
//    List<Activities> findActivitiesById(Long id);

//    Collection<CustomList>findActivitiesById(Long id);
    Collection<CustomList> findActivitiesByPatients(Patient p);
    List<Activities> findActivitiesByPatientsAndIsCompletedAndIsDeleted(Patient p, Boolean isCompleted, Boolean isDeleted);
    List<Activities> findActivitiesByPatientsAndIsCompleted(Patient p, Boolean isCompleted);

    List<Activities> findActivitiesByIsCompleted(Boolean isCompleted);
    Collection<CustomList> findActivitiesByIsDeleted(Boolean x);

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isCompleted = 1")
    int getActivitiesByName();

    @Query(value = "SELECT AVG(rating) FROM Activities")
    int getActivitiesByRating();

    @Query(value = "SELECT COUNT(name) FROM Activities WHERE isDeleted = 0")
    int getActivitiesByNameAndIsDeleted();

    @Query(value = "SELECT COUNT(name) FROM Activities  WHERE isDeleted = 0 AND isCompleted = 0")
    int getActivitiesByNameAndIsDeletedAndIsCompleted();



}
