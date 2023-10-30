package strurday_WebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_CaptreAllOrgNames 
{
	public static void main(String[] args) throws Throwable 
	{
//		Scenario 3:
//		Navigate to VTiger App
//		Navigate to Oranizations page
//		capture all the organization names and prnt in console. 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("(//a[@href='index.php?module=Accounts&action=index'])[1]")).click();
		
		List<WebElement> org = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		
		//table[@class='lvt small']/tbody/tr[*]/td[3]/a[contains(.,'Captian95823')]
		
		for(WebElement e:org)
		{
			String orgName = e.getText();
			System.out.print(orgName+" ");
		}
		
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
