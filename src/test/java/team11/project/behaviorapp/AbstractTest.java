package team11.project.behaviorapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Services.PatientService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BehaviorappApplication.class)
public class AbstractTest {
    @Autowired
    private PatientService patientService;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void PatientTest() throws Exception {
        List<Patient> list = patientService.getAllPatients();

        Assert.assertEquals("Should be 12", 12, list.size());
    }

}
