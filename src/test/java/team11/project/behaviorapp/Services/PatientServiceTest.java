package team11.project.behaviorapp.Services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team11.project.behaviorapp.AbstractTest;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;

import static org.hamcrest.Matchers.hasProperty;


import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PatientServiceTest extends AbstractTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ActivityRepository activityRepository;

    // Test to verify that there are 12 records in the patients table, indicating that the findall query in the service should only return 12 records/patients.
    @Test
    public void getAllPatients() throws Exception {
        List<Patient> list = patientService.getAllPatients();

        Assert.assertEquals("Expected size should be 12 to match the same amount of records available in the database", 12, list.size());
    }

    @Test
    public void getActivityList() throws Exception {
        List<Activities> activityList = activityRepository.findAll();

        Assert.assertEquals("Expected size should be 13 as that is how many activities in the database when the schema is first run", 13, activityList.size());

    }

    // Test that checks that the query in the service/specified below does indeed get a specific record passed in by the user
    @Test
    public void getSpecificRecord() throws Exception {

        Long id = new Long(4);

        Patient record = patientService.getSpecificRecord(id);

        Assert.assertEquals("Should return a patient with the above id", id, record.getID());
    }
    // Tests that the query works by finding the record with the first name "Sam"
    // Retrieves the corresponding surname
    // and checks the size of the resultset which should be one, since there is only one Sam in the DB
    @Test
    public void getPatientByName() throws Exception{
        List<Patient> recordEntry = patientService.getPatientByName("Sam");

        assertThat(recordEntry.size(), is(1));
        assertThat(recordEntry.get(0), allOf(
                hasProperty("firstname", is("Sam")),
                hasProperty("lastname", is("Jones"))

                ));


    }

}