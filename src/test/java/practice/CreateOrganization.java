package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatry.LoginPage;

public class CreateOrganization 
{
	public static void main(String[] args) throws Throwable 
	{
		//Step 1:Create all the object
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		
		
		//Step 2: Read the required data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDataFromExcelFile("Organization",1,2)+jUtil.getRandomNumber();
//		int PHONE=jUtil.getRandomNumber();
		String PHONE = String.valueOf(jUtil.getRandomNumber());
		//Step 3: Launch browser
		WebDriver driver=null;
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
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid browsername");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Step 4: Load the URL
		driver.get(URL);
		//Step 5: Login to application
		/*
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		*/
		wUtil.captureScreenShot(driver, PHONE);
		LoginPage lp=new LoginPage(driver);
		/*
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		*/
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 6: Navigate to organization 
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

		//Step 7: Click on create organization lookup Img
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 8: Create organization with mandatory information
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.qspider.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(PHONE);
		//Step 9: Save 
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Step 10: Validation
		WebElement webEle = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
		if(webEle.isDisplayed())
		{
			System.out.println(webEle);
			System.out.println(webEle.isDisplayed());
		}
		else
		{
			System.out.println("Element not displayed");
		}
		//Step 11: Logout
		/*
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Organization created successfully");
		driver.close();
		*/
		//Step 10: Logout of Application
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successful");
		driver.close();
	}

}
