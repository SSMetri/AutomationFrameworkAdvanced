package practice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingCartApplication 
{
	@Test
	public void main() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("(//img[@alt='Clothing'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.close();
		
		/*
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		list.addAll(List.of(1,2,3,4));
		java.util.Iterator<Integer> iterator=list.iterator();
		list.add(5);
		while (iterator.hasNext()){
		System.out.println(iterator.next()+" ");
		}*/
	}

}
