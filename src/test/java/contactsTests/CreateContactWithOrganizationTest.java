package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import objectReposatry.LoginPage;
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass
{
	@Test(groups="RegressionTest")
	public void createContactWithOrgTest() throws Throwable 
	{
		
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		System.out.println(ORGNAME);
		
		//Navigate to organization 
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on create organization lookup image
		OrganizationPage ob=new OrganizationPage(driver);
		ob.clickOnOrganizationLookUpIcon();
		
		//Create new organization with mandatory fields
		CreateOrganizationPage cnop=new CreateOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Validate for organization
		OrganizationDetailsPage odp=new OrganizationDetailsPage(driver);
		String orgHeader = odp.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader+"Organization is created");
		/*
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization is created");
		}
		else
		{
			System.out.println("Organization creation fail");
		}
		*/
		
		//Click on contacts link
		hp.clickOnContactsLink();
		
		//CLick on lookup image to create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.createContactLookUpIcon();
		
		//Create contact with organization
		CreateConatctPage cncp=new CreateConatctPage(driver);
		cncp.creaeNewCOntact(driver, LASTNAME, ORGNAME);
		
		//Validation
		ContactDetailsPage cdp=new ContactDetailsPage(driver);
		String contatHeader = cdp.getHeaderTest();
		Assert.assertTrue(contatHeader.contains(LASTNAME));
		System.out.println(contatHeader+"Contact created with organization");

		/*
		if(contatHeader.contains(LASTNAME))
		{
			System.out.println(contatHeader);
			System.out.println("Contact created with organization");
		}
		else
		{
			System.out.println("Contact creation failed");
		}
		*/
		
	}

}
