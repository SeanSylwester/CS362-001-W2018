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
		 
		 CalDay blank = new CalDay();
		 blank.iterator();
		 blank.toString();
		 assertFalse(blank.isValid());
		 
		 
		 GregorianCalendar today = new GregorianCalendar(2018,01,29);
		 CalDay greg = new CalDay(today);
		 greg.toString();
		 
		 greg.addAppt(appt);
		 appt.setStartHour(22);
		 greg.addAppt(appt);
		 appt.setStartHour(20);
		 greg.addAppt(appt);
		 appt.setStartDay(50);
		 greg.addAppt(appt);
		 greg.iterator();

		 
		 assertEquals(2, greg.getMonth());
		 assertEquals(1, greg.getDay());
		 assertEquals(2018, greg.getYear());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
