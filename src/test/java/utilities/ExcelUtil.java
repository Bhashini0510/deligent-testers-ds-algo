package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<String> readFromExcel(String path,String sheet, int row) throws IOException{
		
		File file= new File(path);
		FileInputStream fio = new FileInputStream(file);
		
		List<String> inputs = new ArrayList<String>();
		//HSSFWorkbook - .xls
		//XSSFWorkbook - .xlxs
		XSSFWorkbook wb = new XSSFWorkbook(fio);
		XSSFSheet ws = wb.getSheet(sheet);
		Row xlRow=ws.getRow(row); 
		Iterator<Cell> i = xlRow.iterator();
		while(i.hasNext()) {
			Cell cell = i.next();
			inputs.add(cell.getStringCellValue());
		}
		wb.close();
		return inputs;
		
	}

	

}
