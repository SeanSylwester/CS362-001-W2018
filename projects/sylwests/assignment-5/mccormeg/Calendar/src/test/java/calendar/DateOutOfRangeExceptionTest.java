package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  DateOutOfRangeException class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class DateOutOfRangeExceptionTest {
	 @Test
	  public void test01()  throws Throwable  {
		 DateOutOfRangeException test1 = new DateOutOfRangeException();
		 DateOutOfRangeException test2 = new DateOutOfRangeException("test2");
	}

}
