package testNGpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice3 
{
	@Test(priority=1,enabled=true)
	public void Testng3()
	{
//		Assert.fail();  //To fail the script purposfully, onpy for analysis it is used
		System.out.println("Testng 3");
	}
	
	@Test(priority=2,dependsOnMethods="Testng3")
	public void Testng33()
	{
		System.out.println("Testng 33");
	}

}
