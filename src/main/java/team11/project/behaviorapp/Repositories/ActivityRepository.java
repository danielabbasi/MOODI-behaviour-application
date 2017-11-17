package team11.project.behaviorapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;

public interface ActivityRepository extends JpaRepository<Activities, Long>{

}
