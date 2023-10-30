package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationDetailsPage 
{
	//Deceleration
	@FindBy(xpath="(//span[@class='dvHeaderText'])[1]")
	private WebElement headerOfOrganizationPage;
	
	//Initialization
	public OrganizationDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getHeaderOfOrganizationPage() {
		return headerOfOrganizationPage;
	}
	
	//Business Library
	/**
	 * This method will get header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return headerOfOrganizationPage.getText();
	}

}
