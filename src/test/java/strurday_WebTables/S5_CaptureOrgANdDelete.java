package strurday_WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S5_CaptureOrgANdDelete 
{
	public static void main(String[] args) throws Throwable 
	{
//		Scenario 5:
//		Navigate to Organizations page
//		click on 8th check box and capture the Organization name and delete that organization  
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String ORGNAME="Captian95823";
		
		driver.get("http://localhost:8888/index.php");
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("(//a[@href='index.php?module=Accounts&action=index'])[1]")).click();
		
//		String org = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/a[contains(.,'Captian34400')]")).getText();

		String org =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/a[text()='"+ORGNAME+"']")).getText();
				
		System.out.println(org);
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/a[text()='"+ORGNAME+"']")).click();
		
		driver.findElement(By.name("Delete")).click();
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(img);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
		
	}

}
