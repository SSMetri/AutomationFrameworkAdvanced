package cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Browserstack3 
{

	RemoteWebDriver driver;
	
	public static final String USERNAME = "soubhagyametri_PmIdtq";
	public static final String AUTOMATE_KEY = "9ycciTz7CY1Df6M1QyzK";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	//  https://soubhagyametri_PmIdtq:9ycciTz7CY1Df6M1QyzK@hub-cloud.browserstack.com/wd/hub
@Test(dataProvider ="Data")
public void browserRun(Platform platform, String BName, String BVersion) throws MalformedURLException, InterruptedException
{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setPlatform(platform);
	cap.setBrowserName(BName);
	cap.setVersion(BVersion);
	cap.setCapability("name", BName);
	cap.setCapability("browserstack.debug", true);
	
	
	driver = new RemoteWebDriver(new URL(URL),cap);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	
	Actions a=new Actions(driver);
	a.moveByOffset(15,15).click().perform();
	
	driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	driver.findElement(By.xpath("//p[normalize-space()='Mumbai, India']")).click();
	driver.findElement(By.xpath("(//label[@for='toCity'])[1]")).click();
	driver.findElement(By.xpath("//p[normalize-space()='New Delhi, India']")).click();
	
	driver.findElement(By.xpath("(//p[contains(text(),'4')])[4]")).click();
	Thread.sleep(2000);
	driver.close();

	
}

@DataProvider(name ="Data", parallel=true)
public Object[][] getData()
{
	Object[][] test = new Object[][] {
		{Platform.WINDOWS,"chrome","109"},
		{Platform.WINDOWS,"firefox","110"},
		{Platform.MAC,"chrome","80"}};
		return test;
}



}
