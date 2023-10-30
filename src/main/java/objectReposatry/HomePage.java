package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Decleraation
	@FindBy(xpath="(//a[@href='index.php?module=Accounts&action=index'])[1]")
	private WebElement organizationBtn;
	
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	private WebElement contatctsBtn;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/user.PNG'])[1]")
	private WebElement logoutImg;
	
	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement signOutBtn;
	
	@FindBy(xpath="(//a[normalize-space()='Products'])[1]")
	private WebElement productBtn;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getOrganizationBtn() {
		return organizationBtn;
	}
	
	public WebElement getContatctsBtn() {
		return contatctsBtn;
	}
	
	public WebElement getProductsBtn() {
		return productBtn;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	

	
	//Business library
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationBtn.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contatctsBtn.click();
	}
	/**
	 * This method will click on products link
	 */
	public void clickOnProductsLink()
	{
		productBtn.click();
	}
	
	public void logoyrOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, logoutImg);
		Thread.sleep(2000);
		signOutBtn.click();
	}



}
