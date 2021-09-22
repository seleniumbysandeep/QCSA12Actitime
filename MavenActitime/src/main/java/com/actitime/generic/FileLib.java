package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author QSP
 *
 */
public class FileLib {
/**
 * 	
 * @param key
 * @return
 * @throws IOException
 */
public String getPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
}

public String  getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
	FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;
}

}
