package strurday_WebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S1_allCheckBoxes 
{
	public static void main(String[] args) throws Throwable 
	{
//		cenario 1:
//		Navigate to VTiger App
//		Navigate to Oranizations page
//		check on all the check boxes
		
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
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@type='checkbox']")).click();
		
		/* OR
		List<WebElement> check = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@type='checkbox']"));
		int count=0;
		for(WebElement ele:check)
		{
			ele.click();
			count++;
		}
		System.out.println(count);
		*/
		Thread.sleep(4000);
		driver.close();
		
	}

}
