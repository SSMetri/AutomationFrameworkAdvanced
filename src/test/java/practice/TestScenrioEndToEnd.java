package practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenrioEndToEnd 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//Navigate to Contacts link
		driver.findElement(By.xpath("//a[normalize-space()='Contacts']")).click();
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		//Create Contact with Mandatory fields
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ba512a1acvbhnjm");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mahemndra");
		WebElement drop=driver.findElement(By.xpath("//select[@name='leadsource']"));
		Select ele=new Select(drop);
		ele.selectByValue("Cold Call");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		WebElement contact = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		System.out.println(contact.isDisplayed());
			
//		Navigate to Organizations link 
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		Create Organization with Mandatory fields 
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("qsb542kste2");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.qspider.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
		
		//Window handling
		String win1=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> windows = driver.getWindowHandles();
		for(String w:windows)
		{
			driver.switchTo().window(w);
		}
		driver.findElement(By.xpath("(//a[normalize-space()='QSPIDER'])[1]")).click();
		
		driver.switchTo().alert().accept();
		driver.switchTo().window(win1);
		
		
//		Select "Energy" in the industry drop down
		WebElement industry=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s_ind=new Select(industry);
		s_ind.selectByValue("Energy");
//		Select "Customer" in the Type Drop down 
		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select type_drop=new Select(type);
		type_drop.selectByValue("Customer");
		
		WebElement rating=driver.findElement(By.xpath("//select[@name='rating']"));
		Select s=new Select(rating);
		s.selectByValue("Active");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//		Save and Verify
		WebElement webEle = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		System.out.println(webEle.isDisplayed());
		
		driver.findElement(By.xpath("//a[normalize-space()='Contacts']")).click();
		
		WebElement signoutImg=driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(signoutImg).perform();
		signoutImg.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		driver.close();
		
		
	}

}
