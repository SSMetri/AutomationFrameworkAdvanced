package regionalRegression;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectReposatry.ContactDetailsPage;
import objectReposatry.ContactsPage;
import objectReposatry.CreateConatctPage;
import objectReposatry.HomePage;


@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactB_C_Test extends BaseClass
{
	@Test(groups="SmokeTest")
	public void createContactMethodTest() throws Throwable 
	{
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization",7,3);
		String TYPE = eUtil.readDataFromExcelFile("Organization",7,4);
		
		System.out.println(ORGNAME);
		
		//Step 6: Navigate to contacts 
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Navigate to contacts ");
		
		//Step 7: Click on lookup image 
		ContactsPage cp=new ContactsPage(driver);
		cp.createContactLookUpIcon();
		Reporter.log("Click on lookup image");
		
		//Step 8: Fill all required details
		CreateConatctPage cConP=new CreateConatctPage(driver);
		cConP.creaeNewCOntact(LASTNAME);
		Reporter.log("Fill all required details in contats page");
		
		//Step 9: Verification
		ContactDetailsPage orgDet=new ContactDetailsPage(driver);
		String header = orgDet.getHeaderTest();
		Assert.assertTrue(header.contains(LASTNAME));
		System.out.println("******END******");

		Reporter.log("Verification, whether contact is created or not");
		System.out.println("****DONE****");

	}
//	@Test
//	public void demoFail()
//	{
//		System.out.println("demoFail");
//	}
//	@Test(invocationCount=1)
//	public void skipTest()
//	{
//		System.out.println("Test skipped");
//		Reporter.log("Demo test");
//	}

}
