package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectLAstElementFrom_DropDown 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility util=new WebDriverUtility();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		util.maximizeWindow(driver);
		driver.manage().window().maximize();
		util.waitForPageLoad(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		List<WebElement> text = driver.findElements(By.xpath("//select[@name='industry']/option"));
		for(WebElement w:text)
		{
			System.out.print(w.getText()+", ");
		}
		
		if(!text.isEmpty())
		{
			WebElement opt = text.get(text.size()-1);
			opt.click();
		}else {
			System.out.println("Element not found or drop down not found");
		}
		
		/*
		WebElement t = driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select drop=new Select(t);
		List<WebElement> options = drop.getAllSelectedOptions();
		for(WebElement option:options)
		{
			String eleText = option.getText();
			System.out.println("Drop down text : "+eleText);
		}
		
		if(!options.isEmpty())
		{
			WebElement lastOpt=options.get(options.size()-1);
			lastOpt.click();
		}
		else {
            System.out.println("Dropdown is empty or not found.");
        }
        */
		Thread.sleep(4000);
		driver.close();

		
		
	}

}
