package contactsTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectReposatry.ContactDetailsPage;
import objectReposatry.ContactsPage;
import objectReposatry.CreateConatctPage;
import objectReposatry.CreateOrganizationPage;
import objectReposatry.CreateProductListPage;
import objectReposatry.CreateProductPage;
import objectReposatry.HomePage;
import objectReposatry.OrganizationDetailsPage;
import objectReposatry.OrganizationPage;
import objectReposatry.ProductDetailsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithOrgAndProductTest extends BaseClass
{
	@Test(groups="RegressionTest")
	public void createContactWithOrgAndProdTest() throws Throwable   
	{
		
		String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
		
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization",7,3);
		String TYPE = eUtil.readDataFromExcelFile("Organization",7,4);
		
		System.out.println(ORGNAME);
		
		//Step 6: Click on Organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on lookup icon
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickOnOrganizationLookUpIcon();
		
		
		System.out.println("inside org page");
		//Step 7:  Create Organization, click on organization lookup icon
		CreateOrganizationPage corg=new CreateOrganizationPage(driver);
		corg.createNewOrganization(ORGNAME,INDUSTRY,TYPE);
		
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
		
		//Step 9: CLick on Products link in home page
		hp.clickOnProductsLink();
		
		//Step 10: Click on create product lookup
		CreateProductListPage cpp=new CreateProductListPage(driver);
		cpp.clickOnLookUpIcon();
		
		//Step 11: Fill all the details
		CreateProductPage cprodp=new CreateProductPage(driver);
		cprodp.fillDetailsOfProductPage("PRODUCT12345");
		
		//Step 12: Verification
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		String headerProd = pdp.headerTextFromProduct();
		if(headerProd.contains("PRODUCT12345"))
		{
			System.out.println(headerProd);
			System.out.println("Product created");
		}
		else
		{
			System.out.println("Product creation failed");
		}
		
		//Step 13: Click on contacts link
		hp.clickOnContactsLink();
		
		//Step 14: Click on look up icon
		ContactsPage ccp=new ContactsPage(driver);
		ccp.createContactLookUpIcon();
		
		//Step 15: Fill all details
		CreateConatctPage cnewcp=new CreateConatctPage(driver);
		cnewcp.creaeNewCOntact(driver, LASTNAME, ORGNAME);
		
		//Step 16: Validation
		ContactDetailsPage cdp=new ContactDetailsPage(driver);
		String headerContact = cdp.getHeaderTest();
		if(headerContact.contains(LASTNAME))
		{
			System.out.println(headerContact);
			System.out.println("Contacts created");
		}
		else
		{
			System.out.println("Contacts creation failed");
		}
		
		
		
		
	}

}
