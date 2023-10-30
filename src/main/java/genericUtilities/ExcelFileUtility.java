package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class consists of generic methods related to excel file
 * @author metri
 */
public class ExcelFileUtility 
{
	/**
	 * This method will read data from file and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName,int rowNo,int cellNo) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	/**
	 * This method will read multiple data from excel sheet at a time
	 * used for data provider
	 * @param sheetName
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
//		sh.getPhysicalNumberOfRows()
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
	/**
	 * This method will write the data into excel file
	 * @param SheetName
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public void writeData(String SheetName,Object[][] data) throws Throwable
	{
	    FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx");
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet sheet=wb.getSheet(SheetName);
	    int rowNum = sheet.getPhysicalNumberOfRows();
	    int cellNum=sheet.getRow(0).getPhysicalNumberOfCells();
	    
	    for(int i=0;i<rowNum;i++)
	    {
	        Row row=sheet.createRow(i+1);
	       
			for(int j=0;j<cellNum;j++)
	        {
	            Cell cell=row.createCell(j);
	            cell.setCellValue(String.valueOf(data[i][j]));
	        }
	    }
	    FileOutputStream fop = new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx");
	    wb.write(fop);
		
	}

}
