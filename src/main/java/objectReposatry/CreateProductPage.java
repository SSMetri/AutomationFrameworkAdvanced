package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	//Decleration
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productName;
	
	@FindBy(xpath="(//input[contains(@onclick,\"this.form.action.value='Save'; return validateInventory('Products')\")])[1]")
	private WebElement saveBtn;
	
	//Initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	public void fillDetailsOfProductPage(String PRODUCTNAME)
	{
		productName.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}
	
	

}
