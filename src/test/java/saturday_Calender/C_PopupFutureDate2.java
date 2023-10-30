package saturday_Calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C_PopupFutureDate2 
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
		boolean present;
		
		for(;;)
		{
//			driver.findElement(By.xpath("(//span[@aria-label='Next Month'])[1]")).click();
//			driver.findElement(By.xpath("(//span[@aria-label='Next Month'])[1]")).click();
			Thread.sleep(1000);
			try
			{
				driver.findElement(By.xpath("(//div[@class='dateInnerCell'])[38]")).click();
				present=true;
				System.out.println("Pass");
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("(//span[@aria-label='Next Month'])[1]")).click();
				System.out.println("Fail");
				Thread.sleep(2000);
			}
			
		}
		/*
		if(present)
		{
			driver.findElement(By.xpath("(//div[@class='dateInnerCell'])[38]")).click();
			String ele = driver.findElement(By.xpath("(//div[@class='dateInnerCell'])[38]")).getText();
			System.out.println(ele);
		}
		*/
		Thread.sleep(2000);
		driver.close();
		
	}

}
