package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestScenario1 
{
	public static void main(String[] args) 
	{
		WebDriverUtility util=new WebDriverUtility();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		util.maximizeWindow(driver);
//		driver.manage().window().maximize();
		util.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
//		Select ele=new Select(drop);
//		ele.selectByValue("Cold Call");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		WebElement contact = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		System.out.println(contact.isDisplayed());
		WebElement signoutImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		util.mouseHoverAction(driver, signoutImg);
//		Actions a=new Actions(driver);
//		a.moveToElement(signoutImg).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		driver.close();
		
	}

}
