package contactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatry.ContactDetailsPage;
import objectReposatry.ContactsPage;
import objectReposatry.CreateConatctPage;
import objectReposatry.CreateOrganizationPage;
import objectReposatry.HomePage;
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass
{
	@Test(groups="SmokeTest")
	public void createContactMethodTest() throws Throwable 
	{
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//Step 2: Read the required data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME="";
		
		try {
			USERNAME = pUtil.readDataFromPropertyFile("username");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization",7,3);
		String TYPE = eUtil.readDataFromExcelFile("Organization",7,4);
		
		System.out.println(ORGNAME);
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
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Step 6: Navigate to contacts 
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step 7: Click on lookup image 
		ContactsPage cp=new ContactsPage(driver);
		cp.createContactLookUpIcon();
		
		//Step 8: Fill all required details
		CreateConatctPage cConP=new CreateConatctPage(driver);
		cConP.creaeNewCOntact(LASTNAME);
		
		//Step 9: Verification
		ContactDetailsPage orgDet=new ContactDetailsPage(driver);
		String header = orgDet.getHeaderTest();
		if(header.contains(LASTNAME))
		{
			System.out.println(header);
			System.out.println("Contact created");
		}
		else
		{
			System.out.println("Test fail");
		}
		
		//Step 10: Logout of application
		hp.logoyrOfApp(driver);
		
		driver.close();
		
	}

}
