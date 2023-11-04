package cloud;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackContact 
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
	
	WebDriverUtility util=new WebDriverUtility();

	util.maximizeWindow(driver);
//	driver.manage().window().maximize();
	util.waitForPageLoad(driver);
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	//Login to application with valid credentials
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	//Navigate to Contacts link
	driver.findElement(By.xpath("//a[normalize-space()='Contacts']")).click();
	driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
	//Create Contact with Mandatory fields
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bahunmbali");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mahemndra");
	WebElement drop=driver.findElement(By.xpath("//select[@name='leadsource']"));
	util.handleDropDown(drop, "Cold Call");
//	Select ele=new Select(drop);
//	ele.selectByValue("Cold Call");
	driver.findElement(By.xpath("//input[@value='T']")).click();
	driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
	WebElement contact = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
	System.out.println(contact.isDisplayed());
	WebElement signoutImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	util.mouseHoverAction(driver, signoutImg);
//	Actions a=new Actions(driver);
//	a.moveToElement(signoutImg).perform();
	driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
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
