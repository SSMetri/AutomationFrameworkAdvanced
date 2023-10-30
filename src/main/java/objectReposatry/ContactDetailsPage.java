package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage 
{
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	public ContactDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactHeader() {
		return contactHeader;
	}
	
	//Business library
	/**
	 * This method will capture the header and returm it to coller
	 * @return
	 */
	public String getHeaderTest()
	{
		return contactHeader.getText();
	}

}
