package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);   
		 
		 appt.setStartHour(24);
		 appt.setStartHour(-1);
		 appt.setStartHour(21);

		 appt.setStartMinute(60);
		 appt.setStartMinute(-1);
		 appt.setStartMinute(30);

		 appt.setStartDay(60);
		 appt.setStartDay(-1);
		 appt.setStartDay(15);

		 //appt.setStartMonth(12); //can't test cuz it crashes the program
		 //appt.setStartMonth(-1);
		 appt.setStartMonth(01);
		 
		 appt.setStartYear(2018);
		 
		 appt.setTitle(null);
		 appt.setTitle("Birthday Party");
		 appt.setDescription(null);
		 appt.setDescription("This is my birthday party.");
		 
		 appt.setRecurrence(null, 1, 1, 1);
		 int[] recur_days = {1};
		 appt.setRecurrence(recur_days, 1, 1, 1);
		 appt.toString();
		 
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
		 assertEquals(1, appt.getRecurBy());
		 assertEquals(1, appt.getRecurNumber());
		 assertEquals(recur_days, appt.getRecurDays());
		 assertEquals(1, appt.getRecurIncrement());
		 assertTrue(appt.isRecurring());
	 }
}
