package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice 
{
	@Test
	public void softAssert()
	{
		SoftAssert sa=new SoftAssert();
		
//		Assert.assertEquals(0,1);

		System.out.println(1);
		System.out.println(2);
		
		sa.assertEquals(1,2);
		System.out.println(3);
		
		Assert.assertEquals(0,0);
		
		sa.assertEquals(false, false);
		System.out.println(4);
		
		sa.assertAll();
	}

}
