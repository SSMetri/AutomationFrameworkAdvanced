package strurday_WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S4_CheckOnLastCheckBox 
{
	public static void main(String[] args) throws Throwable 
	{
//		Scenario 4:
//		Navigate to Organizations page
//		Click on the last check box
		
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
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[22]/td[1]/input[@type='checkbox']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

}
