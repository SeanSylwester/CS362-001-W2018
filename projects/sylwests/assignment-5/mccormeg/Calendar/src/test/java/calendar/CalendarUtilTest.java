package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalendarUtil class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class CalendarUtilTest {
	 @Test
	  public void test01()  throws Throwable  {
		 assertEquals(29, CalendarUtil.NumDaysInMonth(2004, 1));
		 assertTrue(CalendarUtil.IsLeapYear(2004));
		 assertTrue(CalendarUtil.IsLeapYear(2000));
		 assertFalse(CalendarUtil.IsLeapYear(2005));
		 assertFalse(CalendarUtil.IsLeapYear(1900));
	 }
}
