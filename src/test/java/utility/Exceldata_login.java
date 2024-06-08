package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata_login {
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sh ;
	
		
		public int gettootalrow(String path, String Sheet) throws IOException {
		
		 fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheet);
		int totalrow = sh.getLastRowNum();
		wb.close();
		fi.close();
		return totalrow;
		
		}
			public int gettotalcell(String path, String Sheet,int rownumber) throws IOException {
			 fi = new FileInputStream(path);
				wb = new XSSFWorkbook(fi);
				sh = wb.getSheet(Sheet);
				
			int totalcell = sh.getRow(rownumber).getLastCellNum();
			wb.close();
			fi.close();
			
		return totalcell;
		
		}
			public String celldata(String path, String Sheet,int row , int cell) throws IOException {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			sh = wb.getSheet(Sheet);
			
			String data =sh.getRow(row).getCell(cell).toString();
			
			
			wb.close();
			fi.close();
			return data;
			
			
		}
	
	
}
