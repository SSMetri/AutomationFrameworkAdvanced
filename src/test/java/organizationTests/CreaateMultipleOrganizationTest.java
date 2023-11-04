package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
public class CreaateMultipleOrganizationTest extends BaseClass
{
	
	@Test(dataProvider="getData",groups="RegressionTest")
	public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
	{
		String ORGNAME=ORG+jUtil.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on lookup icon
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickOnOrganizationLookUpIcon();
		System.out.println("inside org page");
		
		//Create Organization, click on organization lookup icon
		CreateOrganizationPage corg=new CreateOrganizationPage(driver);
		corg.createNewOrganization(ORGNAME,INDUSTRY);
		wUtil.captureScreenShot(driver, ORGNAME);
		
		//Validation
		OrganizationDetailsPage odp=new OrganizationDetailsPage(driver);
		String headerOrg = odp.getHeaderText();
		Assert.assertTrue(headerOrg.contains(ORGNAME));
		System.out.println(headerOrg);


	}
	
	@DataProvider
	public Object[][] getData() throws Throwable, IOException
	{
		return eUtil.readMultipleData("MultipleOrganization");
	}
	
	@DataProvider(name ="Data", parallel=true)
	public Object[][] getData1()
	{
		Object[][] test = new Object[][] {
			{Platform.WINDOWS,"chrome","109"},
			{Platform.WINDOWS,"firefox","110"},
			{Platform.MAC,"chrome","80"}};
			return test;
	}

}
