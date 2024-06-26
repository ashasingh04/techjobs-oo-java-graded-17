package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(newJob instanceof Job);

        assertEquals("Product tester",newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String firstChar = String.valueOf(job.toString().charAt(0));
        String lastChar = String.valueOf(job.toString().charAt(job.toString().length()-1));
        assertEquals("\n",firstChar);
        assertEquals("\n",lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));

        String result = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n",job.getId(),job.getName(),job.getEmployer(),job.getLocation(),job.getPositionType(),job.getCoreCompetency());
        assertEquals(result,job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        
        String result = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n",job.getId(),job.getName(),job.getEmployer(),job.getLocation(),job.getPositionType(),job.getCoreCompetency());
        assertEquals(result,job.toString());
    }
}
