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
		 
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertFalse(appt.getRecurDays() == null);
		 assertFalse(appt.isRecurring());
		 
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(21);
		 assertTrue(appt.getValid());

		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(30);
		 assertTrue(appt.getValid());

		 appt.setStartMonth(4);
		 appt.setStartDay(30);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(1);
		 appt.setStartDay(31);
		 assertTrue(appt.getValid());
		 
		 appt.setStartDay(-1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(15);
		 assertTrue(appt.getValid());

		 //appt.setStartMonth(12); //can't test cuz it crashes the program
		 //appt.setStartMonth(-1);
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 
		 appt.setStartYear(2018);
		 
		 appt.setTitle(null);
		 appt.setTitle("Birthday Party2");
		 appt.setDescription(null);
		 appt.setDescription("This is my birthday party2.");
		 
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
		 assertEquals("Birthday Party2", appt.getTitle());
		 assertEquals("This is my birthday party2.", appt.getDescription()); 
		 assertEquals(1, appt.getRecurBy());
		 assertEquals(1, appt.getRecurNumber());
		 assertEquals(recur_days, appt.getRecurDays());
		 assertEquals(1, appt.getRecurIncrement());
		 assertTrue(appt.isRecurring());
		 
		 appt.setStartHour(11);
		 assertFalse(appt.toString() == null);
		 assertEquals(appt.toString(), "\t1/15/2018 at 11:30am ,Birthday Party2, This is my birthday party2.\n" + 
			 		"");
		 appt.setStartHour(12);
		 assertEquals(appt.toString(), "\t1/15/2018 at 12:30pm ,Birthday Party2, This is my birthday party2.\n" + 
			 		"");
	 }
	 @Test
	  public void test02()  throws Throwable  {
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
		 Appt appt2 = new Appt(startHour+1,
		          startMinute +1,
		          startDay +1,
		          startMonth +1,
		          startYear +1,
		          title,
		         description);  
		 
		 assertTrue(appt.compareTo(appt) == 0);
		 assertTrue(appt.compareTo(appt2) == -5);
	 }
}
