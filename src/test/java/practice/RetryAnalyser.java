package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyser 
{
	@Test(retryAnalyzer=genericUtilities.RetryAnalyserImplememtation.class)
	public void demo()
	{
		Assert.fail();
	}

}
