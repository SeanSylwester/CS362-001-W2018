package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	//private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 3 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = System.currentTimeMillis();
		long elapsed = System.currentTimeMillis() - startTime;

		long randomseed;
		Random random;

		int startHour;
		int startMinute;
		int startDay;
		int startMonth;
		int startYear;
		String title;
		String description;
		Appt appt;

		CalDay cal_day;

		System.out.println("Start testing...");

		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				randomseed = System.currentTimeMillis(); 
				random = new Random(randomseed);

				startDay    = ValuesGenerator.getRandomIntBetween(random, -1, 31);
				startMonth  = ValuesGenerator.getRandomIntBetween(random,  1, 12);
				startYear   = ValuesGenerator.RandInt(random);
				GregorianCalendar greg_day = new GregorianCalendar(startYear, startMonth, startDay);
				cal_day = new CalDay(greg_day);

				//add NUM_TESTS randomly generated appts to this CalDay object
				for (int i = 0; i < NUM_TESTS; i++) {
					startHour   = ValuesGenerator.getRandomIntBetween(random, -1, 24);
					startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
					startDay    = ValuesGenerator.getRandomIntBetween(random, -1, 31);
					startMonth  = ValuesGenerator.getRandomIntBetween(random,  1, 12);
					startYear   = ValuesGenerator.RandInt(random);
					title="Birthday Party";
					description="This is my birthday party.";

					appt = new Appt(startHour,
							startMinute ,
							startDay ,
							startMonth ,
							startYear ,
							title,
							description);

					cal_day.addAppt(appt);
				}

				elapsed = System.currentTimeMillis() - startTime;
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){
			System.out.println("NullPointerException Caught!");
		}

		System.out.println("Done testing...");
	}
}
