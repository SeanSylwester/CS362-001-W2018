package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=20;
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
		 
		 
		 GregorianCalendar today = new GregorianCalendar(2018,01,29);
		 CalDay greg = new CalDay(today);
		 assertTrue(greg.getAppts().size() == 0);
		 assertFalse(greg.toString() == null);
		 
		 greg.addAppt(appt);
		 assertTrue(greg.getAppts().size() == 1);
		 
		 appt.setStartHour(22);
		 greg.addAppt(appt);
		 assertTrue(greg.getAppts().size() == 2);
		 
		 appt.setStartHour(5);
		 greg.addAppt(appt);
		 assertTrue(greg.getAppts().size() == 3);
		 
		 appt.setStartHour(23);
		 greg.addAppt(appt);
		 assertTrue(greg.getAppts().size() == 4);
		 
		 appt.setStartDay(50);
		 greg.addAppt(appt);
		 assertTrue(greg.getAppts().size() == 4);
		 
		 assertTrue(greg.getAppts().size() == greg.getSizeAppts());
		 
		 
		 for (int i = 0; i < greg.getAppts().size() - 1; i++)
		 {
			assertTrue(greg.getAppts().get(i).getStartHour() <= greg.getAppts().get(i+1).getStartHour());
		 }
		 
		 assertFalse(greg.iterator() == null);
		 assertFalse(greg.toString() == null);
		 
		 assertEquals(2, greg.getMonth());
		 assertEquals(1, greg.getDay());
		 assertEquals(2018, greg.getYear());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 CalDay blank = new CalDay();
		 assertTrue(blank.iterator() == null);
		 blank.toString();
		 assertFalse(blank.isValid());
	 }
//add more unit tests as you needed	
}
