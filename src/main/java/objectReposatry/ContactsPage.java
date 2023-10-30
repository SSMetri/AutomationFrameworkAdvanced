package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Delceration
	@FindBy(xpath="(//img[@title='Create Contact...'])[1]")
	private WebElement createConactIcon;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getCreateConactIcon() {
		return createConactIcon;
	}
	
	//Business library
	/**
	 * This method will click on create contact lookup icon
	 */
	public void createContactLookUpIcon()
	{
		createConactIcon.click();
	}
}
