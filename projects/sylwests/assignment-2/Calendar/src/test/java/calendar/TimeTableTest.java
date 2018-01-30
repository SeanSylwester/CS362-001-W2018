package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable tt = new TimeTable();
		 Appt appt1 = new Appt(12, 29, 28, 2, 2017, "test title1", "test description1"); 
		 Appt appt2 = new Appt(13, 30, 29, 1, 2018, "test title1", "test description1"); 
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 
		 appts.add(appt2);
		 appt2.setStartDay(28);
		 appts.add(appt2);
		 appt2.setStartDay(27);
		 appts.add(appt2);
		 
		 int[] order = {2, 1, 0};
		 tt.permute(appts, order);
		 
		 tt.deleteAppt(appts, appt2);
		 tt.deleteAppt(null, appt2);
		 tt.deleteAppt(appts, null);
		 
		 appt2.setStartDay(50);
		 tt.deleteAppt(appts, appt2);
		 appts.add(appt2);
		 tt.deleteAppt(appts, appt1);

		 appt2.setStartDay(20);
		 int[] recur_days = {1};
		 appt2.setRecurrence(recur_days, 1, 1, 1);
		 appts.add(appt2);
		 
		 GregorianCalendar firstDay = new GregorianCalendar(2016,01,29);
		 GregorianCalendar lastDay = new GregorianCalendar(2019,01,29);
		 tt.getApptRange(appts, firstDay, lastDay);
		 
		 GregorianCalendar firstDay2 = new GregorianCalendar(2016,01,27);
		 GregorianCalendar lastDay2 = new GregorianCalendar(2016,01,28);
		 tt.getApptRange(appts, firstDay2, lastDay2);
		 
		 GregorianCalendar firstDay3 = new GregorianCalendar(2019,01,27);
		 GregorianCalendar lastDay3 = new GregorianCalendar(2019,01,28);
		 tt.getApptRange(appts, firstDay3, lastDay3);
	 }
}
