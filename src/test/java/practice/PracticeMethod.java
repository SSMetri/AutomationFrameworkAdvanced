package practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeMethod 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		/*driver.navigate().to("URL");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();*/
//		timeouts --> the interface for managing driver timeouts.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement element = null;
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.titleContains("HomePage"));
		
		Wait<WebDriver> waitF=new FluentWait(driver).withTimeout(20,TimeUnit.SECONDS).pollingEvery(10,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		waitF.until(ExpectedConditions.elementToBeClickable(element));
		Wait waitFs=new FluentWait(driver).withTimeout(20,TimeUnit.SECONDS).pollingEvery(10,TimeUnit.SECONDS);
		
		
		/*element.isDisplayed();
		element.isEnabled();
		element.isSelected();*/
		
		Actions a=new Actions(driver);
		a.moveByOffset(10,10).perform();
		a.contextClick(element).perform();
		a.doubleClick(element).perform();
		a.dragAndDrop(element, element).perform();
		a.clickAndHold(element).perform(); 
		
		Select s=new Select(element);
		s.selectByValue(null);
		s.selectByVisibleText(null);
		s.selectByIndex(0);
		
		s.deselectAll();
		s.deselectByIndex(0);
		s.deselectByVisibleText(null);
		s.deselectByValue(null);
		s.getAllSelectedOptions();
		s.getOptions();
		s.isMultiple();
		
		driver.switchTo().frame(""); //id, name, index
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		js.executeScript("arguments[0].scrollToView();",element);
		// arguments is class which has 2 methods --> lick() & scrollToView()
		
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\screenshot\\file.png");
		FileUtils.copyFile(src,dest);
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		
		
		Robot r=new Robot();
		StringSelection source=new StringSelection("??PATH");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(source, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("--dissable-notifications");  // Notification pop-ups
		//These are browser specific pop-ups, 
		
		
		FileInputStream fis=new FileInputStream("Path");
		Properties p=new Properties();
		p.load(fis);
		p.get("Name");
		
		FileInputStream fis1=new FileInputStream("Path");
		Workbook wb=WorkbookFactory.create(fis1);
//		wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		
		Object[][] data = null;
		
		int row=wb.getSheet("Sheet").getLastRowNum();
		int cell=wb.getSheet("Sheet").getRow(0).getLastCellNum();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<cell;j++) {
				data[i][j]=wb.getSheet("Sheet").getRow(i+1).getCell(j).getStringCellValue();
			}
		}

		
		
		
	}

}


