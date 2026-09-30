package miscellaneous;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

//		Opens the file in reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\Data.xlsx");
//		Extract workbook from file 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		Extract sheet from workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of Rows : " + totalRows); // 5
		System.out.println("Number of Cells : " + totalCells); // 4

		System.out.println("\n");
		
		for (int r = 0; r <= totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCells; c++) {
				XSSFCell cell = currentRow.getCell(c);
				System.out.printf("%-15s", cell.toString());
//				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}

		workbook.close();
		file.close();

	}
}
