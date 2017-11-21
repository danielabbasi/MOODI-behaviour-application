package team11.project.behaviorapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team11.project.behaviorapp.Entities.Patient;

import java.util.List;

/**
 * Created by c1443907 on 17/11/2017.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

//    List<Patient>

}
