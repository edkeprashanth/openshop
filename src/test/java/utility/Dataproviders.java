package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders extends Exceldata_login{

	
	@DataProvider(name = "dp1")
	
	public String[][] logindatabyprovider() throws IOException {
		
		String path=".\\testData\\Opencart_LoginData.xlsx";
		String Sheet = "Sheet1";
		int total_row=gettootalrow(path, Sheet);
		
		int total_cell = gettotalcell(path, Sheet,1);
		String [][] da = new String [total_row][total_cell];
		
		for(int i =1 ; i<=total_row;i++) {
			
			for(int j=0;j<total_cell;j++) {
				
				da[i-1][j] =celldata(path, Sheet,i,j);
				
			}
		}
		return da;
	}
}
