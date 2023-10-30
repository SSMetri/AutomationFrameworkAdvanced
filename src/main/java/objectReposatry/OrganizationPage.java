package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	//Deceleration
	@FindBy(xpath="(//img[@title='Create Organization...'])[1]")
	private WebElement createOrganizationIcon;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
	
	//Business library
	/**
	 * This method will click on Organization lookup ion
	 */
	public void clickOnOrganizationLookUpIcon()
	{
		createOrganizationIcon.click();
	}

}
