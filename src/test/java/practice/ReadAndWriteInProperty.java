package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadAndWriteInProperty 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
//		p.load(fisp);
		
		//Write into property file
		p.setProperty("Org_name","Random_name");
		FileOutputStream fop=new FileOutputStream(".\\src\\test\\resources\\Write.properties");
		p.store(fop,"Message");
		System.out.println("File created");
		
	}

}
