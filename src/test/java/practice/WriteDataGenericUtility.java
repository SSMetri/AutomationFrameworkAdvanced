package practice;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;

public class WriteDataGenericUtility extends BaseClass
{
	public static void main(String[] args) throws Throwable 
	{
		ExcelFileUtility eUtil=new ExcelFileUtility();
		Object[][] obj =new Object[1][2];
		obj[0][0]="val1";
		obj[0][1]="val2";
		
		eUtil.writeData("SheetName", obj);
		
	}

}
