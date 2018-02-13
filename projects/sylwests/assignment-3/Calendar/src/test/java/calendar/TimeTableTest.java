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
		 Appt appt2 = new Appt(13, 30, 29, 1, 2018, "test title2", "test description2"); 
		 Appt appt3 = new Appt(-1, 30, 29, 1, 2018, "test title3", "test description3"); 
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<Appt> appts2 = new LinkedList<Appt>();
		 
		 appts.add(appt2);
		 appt2.setStartDay(28);
		 appts.add(appt2);
		 appt2.setStartDay(27);
		 appts.add(appt2);
		 
		 int[] order = {1, 2, 0};
		 appts2 = tt.permute(appts, order);
		 assertTrue(appts2 != null);
		 assertFalse(appts == appts2);
		 
		 assertTrue(tt.deleteAppt(appts, appt2).size() == appts.size());
		 assertTrue(tt.deleteAppt(null, appt2) == null);
		 assertTrue(tt.deleteAppt(appts, null) == null);
		 assertTrue(tt.deleteAppt(appts, appt3) == null);
		 
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
		 assertTrue(tt.getApptRange(appts, firstDay, lastDay) != null);
		 assertTrue(tt.getApptRange(appts, firstDay, lastDay).size() == 1096);
		 
		 GregorianCalendar firstDay2 = new GregorianCalendar(2016,01,27);
		 GregorianCalendar lastDay2 = new GregorianCalendar(2016,01,28);
		 assertTrue(tt.getApptRange(appts, firstDay2, lastDay2) != null);
		 assertTrue(tt.getApptRange(appts, firstDay2, lastDay2).size() == 1);
		 
		 GregorianCalendar firstDay3 = new GregorianCalendar(2019,01,27);
		 GregorianCalendar lastDay3 = new GregorianCalendar(2019,01,28);
		 assertTrue(tt.getApptRange(appts, firstDay3, lastDay3) != null);
		 assertTrue(tt.getApptRange(appts, firstDay3, lastDay3).size() == 1);
	 }
}
