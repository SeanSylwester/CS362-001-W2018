
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   String[] schemes = {"HTTP"};
	   UrlValidator uval = new UrlValidator(schemes);
	   //UrlValidator uval = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES + UrlValidator.NO_FRAGMENTS);
	   //UrlValidator uval = new UrlValidator();
	   System.out.println("Manual Testing");
	   System.out.println("google.com: " + uval.isValid("google.com"));
	   System.out.println("www.google.com: " + uval.isValid("www.google.com"));
	   System.out.println("http://www.google.com: " + uval.isValid("http://www.google.com"));
	   System.out.println("HTTP://www.google.com: " + uval.isValid("HTTP://www.google.com"));
	   //System.out.println("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt: " + uval.isValid("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt")); //ExceptionInInitializerError
	   //System.out.println("https://oregonstate.instructure.com: " + uval.isValid("https://oregonstate.instructure.com")); //ExceptionInInitializerError
	   System.out.println("http://oregonstate.instructure.com: " + uval.isValid("http://oregonstate.instructure.com/"));
	   System.out.println("empty string: " + uval.isValid(""));
	   System.out.println("null: " + uval.isValid(null));
   }
   
   
   public void testYourFirstPartition()
   {
	   //partition: doesn't have scheme	 
	   System.out.println("\nNo Authority Partition:");  
	   UrlValidator uval = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("google.com\t\t\t" + uval.isValid("google.com"));
	   System.out.println("www.google.com\t\t\t" + uval.isValid("www.google.com"));
	   System.out.println("www.google.com/test\t\t" + uval.isValid("www.google.com/test"));
	   System.out.println("www.google.com/test?test\t" + uval.isValid("www.google.com/test?test"));
	 
   }
   public void testYourSecondPartition()
   {
	   //partition: http scheme 
	   System.out.println("\nHTTP Authority Partition:");  
	   UrlValidator uval = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("http://.com\t\t" + uval.isValid("http://.com"));
	   System.out.println("http://www.\t\t" + uval.isValid("http://www."));
	   System.out.println("http://www..com\t\t" + uval.isValid("http://www..com"));
	   System.out.println("http://www.test.com\t" + uval.isValid("http://www.test.com"));
	   System.out.println("http://test.com\t\t" + uval.isValid("http://test.com"));
	   System.out.println("http://www.test\t\t" + uval.isValid("http://www.test"));

   }
   public void testYourThirdPartition()
   {
	   //partition: ftp scheme 
	   System.out.println("\nFTP Authority Partition:");  
	   UrlValidator uval = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("ftp://speedtest.tele2.net\t\t" + uval.isValid("ftp://speedtest.tele2.net"));
	   System.out.println("ftp://test.rebex.net/\t\t" + uval.isValid("ftp://test.rebex.net/"));
	   System.out.println(uval.isValid(""));
   }
   
   public void testIsValid()
   {
	   System.out.println("\nAutomated Testing Failures:");  
	   UrlValidator uval = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		String[] schemes = {"http://", "HTTP://", "ftp://", "FTP://", ""}; 
		String[] authorities = {"www.google.com", "255.255.255.255", "0.0.0.0", ""};
		String[] ports = {":80", ":65535", ":0", ""};
		String[] paths = {"/test", "/test/", "/test/test", "/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~:/?#[]@!$&'()*+,;=`", ""};
		for(int a=0; a<schemes.length; a++)
			for(int b=0; b<authorities.length; b++)
				for(int c=0; c<ports.length; c++)
					for(int d=0; d<paths.length; d++)
					{
						String test_url = schemes[a] + authorities[b] + ports[c] + paths[d];
						try
						{
							if(!uval.isValid(test_url))
								System.out.println("invalid: " + test_url);
							else
								System.out.println("  valid: " + test_url);
						}
						catch (ExceptionInInitializerError e)
						{
							System.out.println("ExceptionInInitializerError: " + test_url);
						}
						catch (NoClassDefFoundError e)
						{
							System.out.println("NoClassDefFoundError: " + test_url);
						}
					}
   }
   


}
