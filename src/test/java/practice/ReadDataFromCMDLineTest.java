package practice;

import org.testng.annotations.Test;

public class ReadDataFromCMDLineTest
{
	@Test
	public void readData()
	{
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(USERNAME+" "+PASSWORD);
	}

}
