package objectReposatry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateConatctPage extends WebDriverUtility
{
	//Decleration
	@FindBy(xpath="(//input[@name='lastname'])[1]")
	private WebElement lastName;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement organizationLookUpIcon;
	
	@FindBy(xpath="//input[contains(@class,'crmbutton small save')]")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//input[@id='search_txt'])[1]")
	private WebElement orgSearchField;
	
	@FindBy(xpath="(//input[@name='search'])[1]")
	private WebElement orgSearchBtn;
	
	
	
	//Initialization
	public CreateConatctPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrganizationLookUpIcon() {
		return organizationLookUpIcon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void creaeNewCOntact(String LASTNAME)
	{
		lastName.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void creaeNewCOntact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastName.sendKeys(LASTNAME);
		
		//click on org lookup icon
		organizationLookUpIcon.click();
		switchToWindow(driver,"Actions");
		orgSearchField.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}

	
}
