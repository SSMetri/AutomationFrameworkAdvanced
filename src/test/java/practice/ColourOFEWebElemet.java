package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ColourOFEWebElemet 
{
	public static void main(String[] args) {
		WebDriverUtility util=new WebDriverUtility();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		System.out.println(driver.manage().getCookies());
//		driver.manage().getCookieNamed(arg0);
//		driver.manage().deleteCookie(null);
//		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed(null);
		
		util.maximizeWindow(driver);
//		driver.manage().window().maximize();
		util.waitForPageLoad(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//Navigate to Contacts link
		WebElement element = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		String c = element.getCssValue("background-color");
		String color = element.getCssValue("color");
//		driver.findElement(By.xpath("//a[@class='hdrLink']")).sendKeys(Keys.ENTER);
		System.out.println("Colour is : "+color);
		System.out.println(c);
		driver.close();
	}

}
