package team11.project.behaviorapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;

import java.util.Collection;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activities, Long>{

    List<Activities> findAll();
//    List<Activities> findActivitiesById(Long id);

    //    Collection<CustomList>findActivitiesById(Long id);
    Collection<CustomList> findActivitiesByPatients(Patient p);

}
