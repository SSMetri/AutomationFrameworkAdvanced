package saturday_Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupFutureDate 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions a=new Actions(driver);
		a.moveByOffset(15,15).click().perform();
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Mumbai, India']")).click();
		driver.findElement(By.xpath("(//label[@for='toCity'])[1]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='New Delhi, India']")).click();
		
		for(int i=1;i<4;i++)
		{
			boolean present;
			driver.findElement(By.xpath("(//span[@aria-label='Next Month'])[1]")).click();
			driver.findElement(By.xpath("(//span[@aria-label='Next Month'])[1]")).click();
			Thread.sleep(1000);
			try{
				driver.findElement(By.xpath("(//div[contains(text(),'December 2023')])[1]"));
				present=true;
			}
			catch(Exception e){
				present=false;
			}
			if(present)
			{
				driver.findElement(By.xpath("(//div[@class='dateInnerCell'])[38]")).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.close();
		
	}
}
