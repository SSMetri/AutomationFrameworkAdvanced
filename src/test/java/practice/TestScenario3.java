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

public class TestScenario3 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility util=new WebDriverUtility();

		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue();
		String INDUSTRY = wb.getSheet("Organization").getRow(7).getCell(3).getStringCellValue();


		
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
		util.maximizeWindow(driver);
//		driver.manage().window().maximize();
		util.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Orgkdcfmste2");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.qspider.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("77777777777");
		
		
//		driver.findElement(By.xpath("//input[@id='phone']")).submit();
		/*
		driver.switchTo().activeElement();
		driver.switchTo().alert();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().parentFrame();
		driver.switchTo().window(PASSWORD);
		*/

//		Select "Chemicals" in the industry drop down
		WebElement industry=driver.findElement(By.xpath("//select[@name='industry']"));
//		industry.click();
		Select s_ind=new Select(industry);
		s_ind.selectByValue(INDUSTRY);
		
		WebElement rating=driver.findElement(By.xpath("//select[@name='rating']"));
		Select s=new Select(rating);
		s.selectByValue("Active");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//		Save and Verify
		WebElement webEle = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		System.out.println(webEle.isDisplayed());
//		logout of Application
		driver.findElement(By.xpath("//img[@style='width:16px;height:16px;']")).click();
		WebElement mouseH=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(mouseH).perform();
		driver.close();
	}

}
