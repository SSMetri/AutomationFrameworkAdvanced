package testNGpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice 
{
	@Test(priority=1,invocationCount=2,enabled=true)
	public void createCustomer()
	{
		Assert.fail();  //To fail the script purposfully, onpy for analysis it is used
		System.out.println("createCustomer");
	}
	
	@Test(priority=2,dependsOnMethods="createCustomer")
	public void modifyCustomer()
	{
		System.out.println("modifyCustomer");
	}
	
	@Test(priority=3)
	public void deleteCustomer()
	{
		System.out.println("deleteCustomer");
	}

}
