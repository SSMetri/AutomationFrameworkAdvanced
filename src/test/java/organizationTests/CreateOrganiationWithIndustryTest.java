package organizationTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectReposatry.CreateOrganizationPage;
import objectReposatry.HomePage;
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrganiationWithIndustryTest extends BaseClass
{
	@Test(groups="RegressionTest")
	public void createOrgWithIndustryTest() throws Throwable 
	{
		
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization",7,3);
		String TYPE = eUtil.readDataFromExcelFile("Organization",7,4);
		
		System.out.println(ORGNAME);
		
		//Navigate to organization 
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//CLick on lookup image 
		OrganizationPage orgP=new OrganizationPage(driver);
		orgP.clickOnOrganizationLookUpIcon();
		
		//Fill all required details
		CreateOrganizationPage cOrgP=new CreateOrganizationPage(driver);
		cOrgP.createNewOrganization(ORGNAME,INDUSTRY,TYPE);
		
		//Verification
		OrganizationDetailsPage orgDet=new OrganizationDetailsPage(driver);
		String header = orgDet.getHeaderText();
		Assert.assertTrue(header.contains(ORGNAME));
		System.out.println(header);
		
	}

}
