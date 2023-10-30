package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(name="website")
	private WebElement websiteName;
	
	@FindBy(name="industry")
	private WebElement industryDrop;
	
	@FindBy(name="accounttype")
	private WebElement typeDrop;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(name="rating")
	private WebElement ratingDrop;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getWebsiteName() {
		return websiteName;
	}

	public WebElement getIndustryDrop() {
		return industryDrop;
	}
	
	public WebElement getTypeDrop() {
		return typeDrop;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getRatingDrop() {
		return ratingDrop;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will vreate organozation with mandatory fields
	 * @param ORGNAME
	 * @param webSiteName
	 * @param PHONE
	 */
	public void createNewOrganization(String ORGNAME)
	{
		organizationName.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new organization with industry dropdrown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param PHONE
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		organizationName.sendKeys(ORGNAME);
		handleDropDown(industryDrop,INDUSTRY);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with mandatory field, industry dropdown and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE)
	{
		organizationName.sendKeys(ORGNAME);
		handleDropDown(industryDrop,INDUSTRY);
		handleDropDown(typeDrop,TYPE);
		saveBtn.click();
	}


	
	
	
	
	
	


}
