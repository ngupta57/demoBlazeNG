package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataInputProvider {	
	
	public static String[][] getData(String sheetname) {		
		String[][] testData = null;				
		try {
			FileInputStream fis = new FileInputStream("./testData/TestCaseInputData.xlsx");		
			XSSFWorkbook wb = new XSSFWorkbook(fis);			
			XSSFSheet sheet = wb.getSheet(sheetname);			
			int rowcount = sheet.getLastRowNum();
			int coloumncount = sheet.getRow(0).getLastCellNum();
			System.out.println(rowcount);
			System.out.println(coloumncount);
			testData = new String[rowcount][coloumncount];			
			for(int i=1; i<=rowcount; i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<coloumncount; j++) {
				String cellData = row.getCell(j).getStringCellValue();
				System.out.println("The value of row "+(i-1)+" and coloumn "+j+" is: "+cellData);
				testData[i-1][j]= cellData;					
				}
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testData;
		
	}	
}
