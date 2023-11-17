package testNGpractice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice 
{
	/*
	@Test(invocationCount=1)
	public void skipTest()
	{
		System.out.println("Test skipped");
		Reporter.log("Demo test");
		String s1="AAAA";
		String s2="AAAAm";
		SoftAssert s=new SoftAssert();
		s.assertEquals(s1,s2);
		s.assertAll();
		System.out.println("Complete");
	}
	*/
	@Test
	public void tryCatch()
	{
		try {
			int i=1/0;
			System.out.println("Print statement");
		}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally block");
		}
		
		System.out.println("**Complete**");
	}

}
