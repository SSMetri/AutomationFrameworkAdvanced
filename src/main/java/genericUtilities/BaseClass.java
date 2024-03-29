package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatry.HomePage;
import objectReposatry.LoginPage;

/**
 * This class consists of 
 */
public class BaseClass 
{
	public WebDriver driver=null;
	public WebDriverUtility wUtil=new WebDriverUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("----DB connection successful----");
	}
	
//	@Parameters("browser")
	@BeforeTest(alwaysRun=true)
//	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		/*
		ChromeOptions chromeOptions=new ChromeOptions();
		FirefoxOptions firefoxOptions=new FirefoxOptions();
		EdgeOptions edgeOptions=new EdgeOptions();
		*/
		
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(/*firefoxOptions*/);
//			firefoxOptions.addArguments("--dissable-notifications");
			System.out.println(BROWSER+"----launched----");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(/*edgeOptions*/);
//			edgeOptions.addArguments("--dissable-notifications");
			System.out.println(BROWSER+"----launched----");		
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(/*chromeOptions*/);
//			chromeOptions.addArguments("--dissable-notifications");
			System.out.println(BROWSER+"----launched----");		
		}
		else
		{
			System.out.println("----Invalid browsername----");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		sdriver=driver;
		
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----Login successful----");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logoyrOfApp(driver);
		System.out.println("----Logout successful----");
	}
	
	@AfterTest(alwaysRun=true)
//	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.close();
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("----DB connection disconnected----");
	}
	

}
