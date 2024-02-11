package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

//comment
/**
 * This class consists of generic methods to read data from property file
 * @author metri
 * 
 */
public class PropertyFileUtility 
{
	/**
	* This method will read data from property file and return the value to caller
	* @param key
	* @return
	* @throws
	*/
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value;
		return value=p.getProperty(key);
		
		
	}

}
