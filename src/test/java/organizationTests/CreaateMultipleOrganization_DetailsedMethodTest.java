package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatry.CreateOrganizationPage;
import objectReposatry.HomePage;
import objectReposatry.LoginPage;
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreaateMultipleOrganization_DetailsedMethodTest extends BaseClass
{
	WebDriverUtility wUtil=new WebDriverUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test(dataProvider="getData",groups="RegressionTest")
	public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
	{

		//Step 2: Read the required data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=ORG+jUtil.getRandomNumber();		
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
		
		Reporter.log("Create Multiple organization test scropt");
				
		//Step 4: Load the URL
		driver.get(URL);
		
		//Step 5: Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
				
		//Step 6: Click on Organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on lookup icon
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickOnOrganizationLookUpIcon();
				
				
		System.out.println("inside org page");
		//Step 7:  Create Organization, click on organization lookup icon
		CreateOrganizationPage corg=new CreateOrganizationPage(driver);
		corg.createNewOrganization(ORGNAME,INDUSTRY);
				
		wUtil.captureScreenShot(driver, ORGNAME);
		
		//Step 8: Validation
		OrganizationDetailsPage odp=new OrganizationDetailsPage(driver);
		String headerOrg = odp.getHeaderText();
		if(headerOrg.contains(ORGNAME))
		{
			System.out.println(headerOrg);
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization creation failed");
		}
		//Step 10: Logout of application
//		hp.logoyrOfApp(driver);
				
		//Step 11: Close browser
		driver.close();
				

	}
	
	@DataProvider
	public Object[][] getData() throws Throwable, IOException
	{
		return eUtil.readMultipleData("MultipleOrganization");
	}
	
	@Test(groups="Smoke",dependsOnGroups="RegressionTest")
	public void test() {
		System.out.println("Pass");
	}

}
