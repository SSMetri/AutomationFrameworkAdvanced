package saturday_Calender;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupCurrentDate 
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
		/*
		Date d=new Date();
		SimpleDateFormat formater=new SimpleDateFormat("dd");
		String date = formater.format(d);
		System.out.println(date);
		
		driver.findElement(By.xpath("(//p[contains(text(),'"+date+"')])[1]")).click();
		*/
		Date d=new Date();
		String date =d.toString();
		System.out.println(date);
		String[] array=d.toString().split(" ");
		String currentDate=array[0]+" "+array[1]+" "+array[2]+" "+array[5];
		System.out.println(currentDate);
		
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']\r\n")).click();
								//div[@aria-label='Fri Dec 08 2023']

		
		Thread.sleep(3000);
		driver.close();

	}

}
