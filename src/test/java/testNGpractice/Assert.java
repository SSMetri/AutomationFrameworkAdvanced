package testNGpractice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert 
{
	@Test
	public void test()
	{
		System.out.println("Print 1");
		int n1=1,n2=1;
		SoftAssert s=new SoftAssert();
//		s.fail();
		System.out.println("Print 2");
		s.assertEquals(n1,n2);
		s.assertAll();
		System.out.println("Print 3");
		
	}

}
