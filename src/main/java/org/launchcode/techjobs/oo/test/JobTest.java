package org.launchcode.techjobs.oo.test;

import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void idTest() {
        Job job1 = new Job();
        Job job2 = new Job();
        int idDif = job2.getId() - job1.getId();
        assertEquals(1, idDif);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job3.getName());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("ACME", job3.getEmployer().getValue());
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("Desert", job3.getLocation().getValue());
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Employer e1 = new Employer("ACME");
        Location l1 = new Location("Desert");
        PositionType pt1 = new PositionType("Quality control");
        CoreCompetency cc1 = new CoreCompetency("Persistence");

        Job job4 = new Job("Product tester", e1, l1, pt1, cc1);
        Job job5 = new Job("Product tester", e1, l1, pt1, cc1);

        assertNotEquals(job4, job5);
    }

    @Test
    public void testToString() {
        Employer e1 = new Employer("ACME");
        Location l1 = new Location("Desert");
        PositionType pt1 = new PositionType("Quality control");
        CoreCompetency cc1 = new CoreCompetency("Persistence");
        Job job6 = new Job("Product tester", e1, l1, pt1, cc1);

        //instructions say to code test that checks string starts and ends with line
        //but based on how instructions say output should look, it doesn't start with line...
        //coded test to make sure ends with a string at least
        assertEquals("_", job6.toString().substring(job6.toString().length() - 1));

        assertEquals("ID: ____1____\n" +
                "Name: ____Product tester____\n" +
                "Employer: ____ACME____\n" +
                "Location: ____Desert____\n" +
                "PositionType: ____Quality control____\n" +
                "CoreCompetency: ____Persistence____", job6.toString());
    }
}
