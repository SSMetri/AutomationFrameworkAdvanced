package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWIthContatct 
{
	public static void main(String[] args) throws Throwable 
	{
		//Step 1:Create all the object
				JavaUtility jUtil=new JavaUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				
				//Step 2: Read the required data
				String BROWSER=pUtil.readDataFromPropertyFile("browser");
				String URL=pUtil.readDataFromPropertyFile("url");
				String USERNAME=pUtil.readDataFromPropertyFile("username");
				String PASSWORD=pUtil.readDataFromPropertyFile("password");
				
				String ORGNAME=eUtil.readDataFromExcelFile("Contacts",7,3)+jUtil.getRandomNumber();
				String LASTNAME=eUtil.readDataFromExcelFile("Contacts",7,2)+jUtil.getRandomNumber();
				System.out.println(ORGNAME);
				//Step 3: Launch browser
				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					System.out.println(BROWSER+" launched");
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					System.out.println(BROWSER+" launched");
				}
				else
				{
					System.out.println("Invalid browsername");
				}
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				
				//Step 4: Load the URL
				driver.get(URL);
				//Step 5: Login to application
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				
				//Step 6: Navigate to organization 
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

				//Step 7: Click on create organization lookup Img
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

				//Step 8: Create organization with mandatory information
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@name='website']")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("77777777777");
				//Step 9: Save 
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//				Thread.sleep(2000);
				//Step 10: Validation
				WebElement webEle = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']"));
				if(webEle.isDisplayed())
				{
					System.out.println(webEle);
					System.out.println(webEle.isDisplayed());
					System.out.println("ORganization created successfully");
				}
				else
				{
					System.out.println("Element not displayed");
				}
				
				System.out.println("New organization create contact");
				
				
				Thread.sleep(2000);
				//Step 11: Navigate to contacts
				driver.findElement(By.xpath("(//a[@href='index.php?module=Contacts&action=index'])[1]")).click();
				Thread.sleep(2000);
				//Step 12: Click on create contact lookup
				driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();

				//Step 13: create contact with mandatory fields
				driver.findElement(By.xpath("(//input[@name='lastname'])[1]")).sendKeys(LASTNAME);
				
				//Step 14: Click on ORG lookup icon
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				wUtil.switchToWindow(driver,"Accounts");
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
				System.out.println(ORGNAME);
				driver.findElement(By.xpath("//input[@name='search']")).click();
				
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
				//Dynamic xpath :- ORGNAME is dynamic
				//XPATH is changing dynamically 
				//xpath : //a[text()='"+variableName+"']
				wUtil.switchToWindow(driver, "Contacts");
				
				//Step : Save
				driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
				System.out.println("Saved");
				//Step  : Verification
				String wele = driver.findElement(By.xpath("(//span[@class='dvHeaderText'])[1]")).getText();
				if(wele.contains(ORGNAME))
				{
					System.out.println(wele);
					System.out.println("Contact created");
				}
			
				else
				{
					System.out.println("Element not displayed");
				}
				
				//Step 10: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successful");
				driver.close();
				
				
	}

}
