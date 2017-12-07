package team11.project.behaviorapp.Controllers.API.GP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.*;

/**
 * Created by c1628725 on 07/12/2017.
 */

@RestController
@RequestMapping(path = "/api/gp")
public class GPIndexAPI {

    @Autowired
    public GPIndexAPI() { }
}
