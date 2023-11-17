package testNGpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice4 
{
	@Test(priority=1,enabled=true)
	public void Testng()
	{
		Assert.fail();  //To fail the script purposfully, onpy for analysis it is used
		System.out.println("Testng4");
	}
	
	@Test(priority=2,dependsOnMethods="Testng")
	public void Testng44()
	{
		System.out.println("Testng44");
	}

}
