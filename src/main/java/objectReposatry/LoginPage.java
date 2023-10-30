package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1
{
	//Rule 2 : Delceration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	//Rule 3 : Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);;
	}
	
	//Rule 4 : Utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business Libraries - Generic method according to the need of project
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	

}
