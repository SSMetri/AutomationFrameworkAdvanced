package practice;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtest 
{
	@Test
	public void main() {
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
////		WebDriverManager.chromedriver().setup();
////		WebDriver driver=new ChromeDriver();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.amazon.in/");
//		List<WebElement> elements = driver.findElements(By.tagName("a"));
//		for(WebElement ele:elements) {
//			System.out.println(ele.getText());
//		}
//		driver.close();
		
		String s="Stssriing",x="sTRING";
		System.out.println(s.equalsIgnoreCase(x));
		String ss=s.toLowerCase();
		char[] ch=ss.toCharArray();
		Map m=new TreeMap();
		for(int i=0;i<s.length();i++) {
			int count=0;
			for(int j=0;j<s.length();j++) {
				if(ch[i
				      ]==ch[j]) {
					count++;
				}
			}
			m.put(ch[i],count);
		}
		System.out.println(m);
	}

}
