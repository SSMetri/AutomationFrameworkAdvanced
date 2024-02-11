package tmobiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtilities.BaseClass;
import genericUtilities.WebDriverUtility;
import genericUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatry.TmobileCheckBoxPage;

public class Tmobile {
	public static void main(String[] args) {
		WebDriverUtility wUtil=new WebDriverUtility();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		TmobileCheckBoxPage box=new TmobileCheckBoxPage(driver);
		driver.manage().window().maximize(); 
		driver.get("https://www.t-mobile.com/cell-phones?brand=apple%7Coneplus");
//		driver.findElement(By.xpath("//label[@for='mat-checkbox-11-input']//span[@class='mat-checkbox-inner-container']")).click();
		
//		driver.findElement(By.xpath("//label[@for='mat-checkbox-11-input']//span[@class='mat-checkbox-inner-container']")).click();
		wUtil.scrollDownAction(driver);
		
//		box.selectCheckBoxes("all");
		box.selectCheckBoxes("motorola");

		

		driver.close();
	}

}
