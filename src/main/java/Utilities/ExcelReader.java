package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class ExcelReader {

	private Workbook workbook;
	private String path;
	private Iterator<Row> rowIterator;
	private Sheet sheet;
	
	public ExcelReader (String path) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.path = path;
		path="src\\main\\java\\Resources\\CN_test_data.xlsx";
		workbook=WorkbookFactory.create(new File(path));
		sheet=workbook.getSheetAt(0);
		rowIterator = sheet.rowIterator();

	}
	
	public String getData(String key, int row) {
		

		//workbook.getSheetAt(0).getRow(1).getCell(1).toString(); 
		return workbook.getSheetAt(0).getRow(row).getCell(CellReference.convertColStringToIndex(key)).toString(); 
		
	}
	
	public int getColumn(String column) {
		
		return 1;
	}
	
	
	public int getRow(int row) {
		return 1;
	}
	
	
}
