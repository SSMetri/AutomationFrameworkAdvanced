package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage 
{
	//Decleration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	//Initialization
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//Business Library
	public String headerTextFromProduct()
	{
		return headerText.getText();
	}
	
	

}
