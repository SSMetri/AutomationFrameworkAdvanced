package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile 
{
	public static void main(String[] args) throws Throwable {
		//Step1: Opean the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step2: Create a workBook
		Workbook wb = WorkbookFactory.create(fis);
		//Step3: Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		//Steo4: Navigate to required row
		Row row=sh.getRow(0);
		//Step5: Navigate to cell
		Cell cel = row.getCell(1);
		//Step6: Capture the value and print
		String value = cel.getStringCellValue();
		System.out.println(value);
		
		String val = wb.getSheet("Organization").getRow(0).getCell(0).getStringCellValue();
		System.out.println(val);
		
		Sheet prod= wb.createSheet("NewSheet");
		prod.createRow(0).createCell(0).setCellValue("Value");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
	}

}
