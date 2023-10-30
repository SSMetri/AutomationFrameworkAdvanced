package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to the IRetryAnalyser interface of TestNG
 * @author metri
 */
public class RetryAnalyserImplememtation implements IRetryAnalyzer
{
	int count=0;
	int retryCount=3;  //Manualy tested, take same 
	
	public boolean retry(ITestResult result)
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
