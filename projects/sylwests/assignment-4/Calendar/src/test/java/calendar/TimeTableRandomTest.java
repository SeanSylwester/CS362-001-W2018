package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	//private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 3 seconds */
	private static final int NUM_TESTS=100;


	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"deleteAppt","getApptRange"};
		int n = random.nextInt(methodArray.length);

		return methodArray[n] ; // return the method name 
	}


	/**
	 * Generate Random Tests that tests TimeTable Class.
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
		LinkedList<Appt> appts = null;
		int appts_length;
		
		GregorianCalendar greg_day1;
		GregorianCalendar greg_day2;

		System.out.println("Start testing...");

		try{ 
			TimeTable tt = new TimeTable();

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				randomseed = System.currentTimeMillis(); 
				random = new Random(randomseed);

				startDay    = ValuesGenerator.getRandomIntBetween(random, -1, 31);
				startMonth  = ValuesGenerator.getRandomIntBetween(random,  1, 12);
				startYear   = ValuesGenerator.RandInt(random);
				greg_day1 = new GregorianCalendar(startYear, startMonth, startDay);

				startDay    = ValuesGenerator.getRandomIntBetween(random, -1, 31);
				startMonth  = ValuesGenerator.getRandomIntBetween(random,  1, 12);
				startYear   = ValuesGenerator.RandInt(random);
				greg_day2 = new GregorianCalendar(startYear, startMonth, startDay);

				appts = new LinkedList<Appt>();


				//add NUM_TESTS randomly generated appts to the linked list
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

					appts.add(appt);
				}
				
				//run NUM_TESTS on the linked list
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


					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					if (methodName.equals("deleteAppt")){
						//try to delete a random one that's probably not there
						if(ValuesGenerator.getBoolean((float)0.99, random))
							tt.deleteAppt(appts, appt);
						else if(ValuesGenerator.getBoolean((float)0.33, random))
							tt.deleteAppt(null, appt);
						else if(ValuesGenerator.getBoolean((float)0.50, random))
							tt.deleteAppt(appts, null);
						else 
							tt.deleteAppt(null, null);

						//delete one that's definitely there - a random appt from the list
						appts_length = appts.toArray(new Appt[0]).length;
						tt.deleteAppt(appts, appts.get(ValuesGenerator.getRandomIntBetween(random, 0, appts_length-1)));
					}
					else if (methodName.equals("getApptRange")){
						if(greg_day1.before(greg_day2))
							tt.getApptRange(appts, greg_day1, greg_day2);
						else
							tt.getApptRange(appts, greg_day2, greg_day1);
					}
				}

				elapsed = System.currentTimeMillis() - startTime;
				if((iteration%1)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){
			System.out.println("NullPointerException Caught!");
		}

		System.out.println("Done testing...");
	}
}
