package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related
 * to web driver actions
 * @author metri
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
//		driver.manage().window().minimize();
	}

	/**
	 *This method waits until all elements gets loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for a particular element to be visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for a particular element to be clickable in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for a particular element will be visible, uses fluent wait 
	 * @param driver
	 * @param element
	 * @param locator
	 * @return
	 */
	public WebElement flueintWait(WebDriver driver,WebElement element,String locator)
	{
		org.openqa.selenium.support.ui.FluentWait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<>(driver)  
        	    .withTimeout(Duration.ofSeconds(30))
        	    .pollingEvery(Duration.ofSeconds(2))
        	    .ignoring(NoSuchElementException.class);
        
        element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        return element;
	}
	/**
	 * This method will select from dropdown by Index
	 * @param driver
	 * @param element
	 */
	public void handleDropDown(WebDriver driver,WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select from dropdown by Value
	 * @param driver
	 * @param element
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);;
	}
	/**
	 * This method will select from dropdown by Visible text
	 * @param driver
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will move to elemet, performs mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method will move the cursor on offset and click on webpage
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveByOffset(10,10).click().perform();
	}
	/**
	 * This method will perform context click, that is right click operation
	 * @param driver
	 * @param element
	 */
	public void contextClickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method will perform double click opearation on element 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method will drag the web element from element1 to element2
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public void dragAndDrop(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(element1, element2).perform();
	}
	/**
	 * This methods switches into frame using index
	 * @param driver
	 * @param index
	 */
	public void swithcToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This methods switches into frame using name or id
	 * @param driver
	 * @param name
	 */
	public void swithcToFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This methods switches into frame using WebElement
	 * @param driver
	 * @param id
	 */
	public void swithcToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void swithcToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 * @param element
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500);","");
	}
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 * @param element
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,-500);","");
	}

	/**
	 * This method will accept the alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert pop-up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	/**
	 * This method will return the alert pop-up text
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will take screenshot and returns the dst path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshots\\"+screenShotName+".png");
										     //Scenario1.png
		Files.copy(src,dst);
		
		return dst.getAbsolutePath(); //Used for reports
	}
	/**
	 * This method switches to windows
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//Step 1: get all the window IDs
		 Set<String> allWinIds = driver.getWindowHandles();
		 
		 //Step 2:Navigate through each window
		 for(String winId:allWinIds)
		 {
			 //Step 3: Switch to each window and capture the title
			 String actTitle = driver.switchTo().window(winId).getTitle();
			 
			 //Step 4: Compare actual title with expected partial title 
			 if(actTitle.contains(partialWindowTitle))
			 {
				 break;
			 }
		 }
	}
	
	
	

}
