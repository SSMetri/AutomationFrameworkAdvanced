package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 */
public class JavaUtility 
{
	/**
	 * This method will generate random number for every run
	 * and return it to caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int r=ran.nextInt(100000);  // 10000 is range
		return r;
	}
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formater.format(d);
		return date;
	}

}
