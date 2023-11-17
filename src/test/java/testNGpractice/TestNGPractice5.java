package testNGpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice5 
{
	@Test(priority=1,enabled=true)
	public void Testng5()
	{
//		Assert.fail();  //To fail the script purposfully, onpy for analysis it is used
		System.out.println("Testng5");
	}
	
	@Test(priority=2)
	public void Testng55()
	{
		System.out.println("Testng55");
	}

}
