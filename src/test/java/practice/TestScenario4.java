package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario4 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String orgName = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue();
		String INDUSTRY = wb.getSheet("Organization").getRow(7).getCell(3).getStringCellValue();
		String TYPE = wb.getSheet("Organization").getRow(7).getCell(4).getStringCellValue();
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
//		Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		Navigate to Organizations link 
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		Create Organization with Mandatory fields 
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Obzxmkn_wajm nkste2");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.qspider.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
//		Select "Energy" in the industry drop down
		WebElement industry=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s_ind=new Select(industry);
		s_ind.selectByValue(INDUSTRY);
//		Select "Customer" in the Type Drop down 
		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select type_drop=new Select(type);
		type_drop.selectByValue(TYPE);
		
		WebElement rating=driver.findElement(By.xpath("//select[@name='rating']"));
		Select s=new Select(rating);
		s.selectByValue("Active");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//		Save and Verify
		WebElement webEle = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		if(webEle.isDisplayed())
		{
			System.out.println(webEle.isDisplayed());
		}
		else
		{
			System.out.println("Element not displayed");
		}
//		logout of Application
		WebElement signoutImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		if(signoutImg.isSelected())
		{
			Actions a=new Actions(driver);
			signoutImg.click();
			a.moveToElement(signoutImg).perform();
			driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		}
		else
		{
			System.out.println("SIgnout fail");
		}
		
		
		driver.close();
		
	}

}
