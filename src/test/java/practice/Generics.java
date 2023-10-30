package practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class Generics 
{
	public static void main(String[] args) throws Throwable 
	{
		PropertyFileUtility pr=new PropertyFileUtility();
		String BROWSER = pr.readDataFromPropertyFile("browser");
		String URL = pr.readDataFromPropertyFile("url");
		String USERNAME = pr.readDataFromPropertyFile("username");
		String PASSWORD = pr.readDataFromPropertyFile("password");
		System.out.println(BROWSER+" "+URL+" "+USERNAME+" "+PASSWORD);
		
		ExcelFileUtility gen_E=new ExcelFileUtility();
		String val = gen_E.readDataFromExcelFile("Contacts",1,1);
		System.out.println(val);
		
		JavaUtility jutil=new JavaUtility();
		int res = jutil.getRandomNumber();
		System.out.println(res);
		
		String s=jutil.getSystemDate();
		System.out.println(s);
	}

}
