package testNGpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice2 
{
	@Test(priority=1,enabled=true)
	public void TestNG2()
	{
//		Assert.fail();  //To fail the script purposfully, onpy for analysis it is used
		System.out.println("Testng 2");
	}
	
	@Test(priority=2,dependsOnMethods="TestNG2")
	public void TestNG_M2()
	{
		System.out.println("Testng 22");
	}

}
