package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author priyaranjan
 *
 */
public class ExcelUtility {
	/**
	 *its used to read the data from excel file  
	 * @return
	 * @throws InvalidFormatException 
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws InvalidFormatException{
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(IConstants.excelPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fileInputStream);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		 org.apache.poi.ss.usermodel.Row row = sheet.getRow(rowNum);
		 org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}
	/**
	 * its used to write data into excel file
	 * @param sheetName
	 * @return
	 * @throws InvalidFormatException 
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws InvalidFormatException {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(IConstants.excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fileInputStream);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		 org.apache.poi.ss.usermodel.Row row = sheet.getRow(rowNum);
		 org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(IConstants.excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
