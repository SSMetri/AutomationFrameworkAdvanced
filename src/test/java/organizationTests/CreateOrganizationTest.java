package organizationTests;

import org.testng.Assert;
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
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="SmokeTest")
	public void createOrgTest() throws Throwable 
	{
		
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		
		System.out.println(ORGNAME);
		
		//Navigate to organization 
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//CLick on lookup image 
		OrganizationPage orgP=new OrganizationPage(driver);
		orgP.clickOnOrganizationLookUpIcon();
		
		//Fill all required details
		CreateOrganizationPage cOrgP=new CreateOrganizationPage(driver);
		cOrgP.createNewOrganization(ORGNAME);
		
		//Verification
		OrganizationDetailsPage orgDet=new OrganizationDetailsPage(driver);
		String header = orgDet.getHeaderText();
		Assert.assertTrue(header.contains(ORGNAME));
		System.out.println(header);
//		Assert.fail();
		
	}
	@Test(groups="RegressionTest",dependsOnGroups="SmokeTest")
	public void test() {
		System.out.println("Pass");
	}

}
