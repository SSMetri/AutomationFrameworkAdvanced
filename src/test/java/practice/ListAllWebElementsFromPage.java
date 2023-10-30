package practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ListAllWebElementsFromPage 
{
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		List<WebElement> allElements = driver.findElements(By.tagName("a"));
		for(WebElement ele:allElements)
		{
			System.out.println("Tagname : "+ele.getTagName()+", link : "+ele.getText());
		}
		driver.close();
		
	}

}
