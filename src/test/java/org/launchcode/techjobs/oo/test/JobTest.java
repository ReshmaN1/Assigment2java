package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest{
    private Job firstJob, secondJob, thirdJob, fourthJob, fifthJob;

    @Before
    public void creatTestJobObjects() {
        firstJob = new Job("first tester", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        secondJob = new Job("second tester", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        thirdJob = new Job("Product tester", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        fourthJob = new Job("", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        fifthJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        //Test that the ID values for the two objects are NOT the same and differ by 1
        Job job = new Job();
        Job newJob = new Job();
        assertEquals(1, secondJob.getId() - firstJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        thirdJob = new Job("Product tester", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", thirdJob.getName());
        assertEquals("ACNE", thirdJob.getEmployer().getValue());
        assertEquals("Desert", thirdJob.getLocation().getValue());
        assertEquals("Quality Control", thirdJob.getPositionType().getValue());
        assertEquals("Persistence", thirdJob.getCoreCompetency().getValue());

        assertTrue( null!=thirdJob.getName());
        assertTrue( null!=thirdJob.getEmployer().getValue());
        assertTrue( null!=thirdJob.getLocation().getValue());
        assertTrue( null!=thirdJob.getPositionType().getValue());
        assertTrue( null!=thirdJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(firstJob == secondJob);
    }

    //Test Driven Development (TDD) : write tests to satisfy requirments of our future toString method
    //TODO1. When passed a Job object, it should return a string that contains a blank line before and after the job information
    @Test
    public void testToStringRetirnsNewLine() {
        //Get first charcater of string
        char firstCharacter = thirdJob.toString().charAt(0);
        // Get last character
        char lastCharacetr = thirdJob.toString().charAt(thirdJob.toString().length() - 1);
        assertTrue(firstCharacter == lastCharacetr);
    }
    //TODO 2.  The string should contain a label for each feils, follwed by the data stored in that field.
    // Each field should be on its own line.

    @Test
    public void getToStringContainsLabelAndData() {
        String label = "Name";
        String data = thirdJob.getName();
        thirdJob.toString().contains(label);
        assertTrue(thirdJob.toString().contains(label));
        assertTrue(thirdJob.toString().contains(":"));
        assertTrue(thirdJob.toString().contains(data));
    }

    // TODO 3. If a field is empty, the method should add, "Data not avaliable" after the label.

    @Test
    public void testToStringOutputsDataNotAvaliable() {
        assertTrue("Data not avaliable", fourthJob.getName() == "");
    }

    // TODO 4. (Bonus) If a job object ONLY contains data for the Id field, the method should return, "OOpS! This job does not seem to exist."

    @Test
    public void testToStringOnlyContainsId() {
        assertTrue(fifthJob.toString().contentEquals("Data is not available"));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Job job  = new Job("Product tester", new Employer("Sdf"), new Location("Stl"), new PositionType("Java"), new CoreCompetency("Persistence"));

        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringHandlesEmptyField() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job  = new Job("Product tester", new Employer(""), new Location("Stl"), new PositionType(""), new CoreCompetency("Persistence"));
        assertEquals("Deta ia not available", job.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job  = new Job("Product tester", new Employer("LaunchCode"), new Location("Stl"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
    }

}
