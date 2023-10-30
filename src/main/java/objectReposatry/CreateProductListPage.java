package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductListPage 
{
	//Decleration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productLookupIcon;
	
	//Initialization
	public CreateProductListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getProductLookupIcon() {
		return productLookupIcon;
	}
	
	public void clickOnLookUpIcon()
	{
		productLookupIcon.click();
	}
	
	

}
