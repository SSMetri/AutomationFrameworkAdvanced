package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility util=new WebDriverUtility();
		//Step1: Read data fro property file
		//Read from property file
		FileInputStream fixp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fixp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		//Step2: Launching browser 
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		util.maximizeWindow(driver);
//		driver.manage().window().maximize();
		util.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//Navigate to Contacts link
		driver.findElement(By.xpath("//a[normalize-space()='Contacts']")).click();
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		//Create Contact with Mandatory fields
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bahunmbali");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		WebElement drop=driver.findElement(By.xpath("//select[@name='leadsource']"));
		util.handleDropDown(drop, "Cold Call");
//		Select ele=new Select(drop);
//		ele.selectByValue("Cold Call");
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		WebElement contact = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		if(contact.isDisplayed())
		{
			System.out.println(contact.isDisplayed());
		}
		else
		{
			System.out.println("Elemenet not found");
		}
		
		WebElement signoutImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
//		Actions a=new Actions(driver);
//		a.moveToElement(signoutImg).perform();
		util.mouseHoverAction(driver, signoutImg);
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		driver.close();
		

		
	}

	

}
