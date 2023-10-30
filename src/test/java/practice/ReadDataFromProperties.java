package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromProperties 
{
	public static void main(String[] args) throws Throwable 
	{
		//Step1:
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Step2:Create object of propertiies
		Properties p=new Properties();
		//Step3:Load the fileinputstream from java.util pakage
		p.load(fis);
		//Step4:provide the key and read the value
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String user = p.getProperty("userName");
		String pwd = p.getProperty("password");
		System.out.println(browser+" , "+url+" , "+user+" , "+pwd);

	}

}
