package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheetAt(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getCellData(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
	}
	
	public static void getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows: "+rowCount);
	}

}
