package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */

public class JobTest {
  private Job firstJob ,SecondJob, thirdJob , fourthJob,fifthJob;

  @Before
    public void creatTestJobObjects(){
      firstJob = new Job();
      secondJob = new Job();
      thirdJob = new Job("prodect tester" , new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"),new CoreCompetency("Persistence"));
      fourthJob = new Job("", new Employer("ACNE"), new Location("Desert"), new PositionType("Quality Control"),new CoreCompetency("Persistence"));
      fifthJob = new Job("", new Employer(""),new Location(""), new PositionType(""), new CoreCompetency(""));
  }

  @Test
    public void testSettingJobID{
      //Test that the ID values for the two objects are NOT the same and differ by 1
        assertEquals(1, secondJob.getId() - firstJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", thirdJob.getName());
        assertEquals("ACNE", thirdJob.getEmployer());
        assertEquals("Desert", thirdJob.getLocation());
        assertEquals("Quality Control", thirdJob.getPositionType().getValue());
        assertEquals("Persistence", thirdJob.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality (){
      assertFalse(firstJob.equals(secondJob));
    }

    //Test Driven Development (TDD) : write tests to satisfy requirments of our future toString method
    //TODO1. When passed a Job object, it should return a string that contains a blank line before and after the job information
    @Test
    public void testToStringRetirnsNewLine() {
      //Get first charcater of string
        char firstCharacter = thirdJob.toString().charAt(0);
        // Get last character
        char lastCharacetr = thirdJob.toString().charAt(thirdJob.toString().lenght()-1);
        assertTrue(firstCharacter==lastCharacetr);
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
      assertTrue(fifthJob.toString().contentEquals("OOPS! This job does not seem to exist."));
    }

}
