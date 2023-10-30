package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsModule 
{
	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
//		Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("iPhone");
		driver.findElement(By.xpath("//img[@id='jscal_trigger_sales_start_date']")).click();
		driver.findElement(By.id("jscal_trigger_sales_start_date")).click();
		WebElement drop=driver.findElement(By.xpath("//select[@name='productcategory']"));
		Select s=new Select(drop);
		s.selectByValue("Software");
		
		driver.findElement(By.xpath("//input[@id='productcode']")).sendKeys("852dfghj");
		WebElement drop2=driver.findElement(By.xpath("//select[@name='manufacturer']"));
		Select s2=new Select(drop2);
		s2.selectByValue("AltvetPet Inc.");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.web");
		driver.findElement(By.xpath("//input[@id='unit_price']")).sendKeys("59999");
		driver.findElement(By.xpath("//input[@id='tax1_check']")).click();
		driver.findElement(By.xpath("(//input[@id='tax2_check'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='tax3_check'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='tax3_check'])[1]")).click();


		driver.close();
	}

}
