package utiles;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;

import java.util.List;
 
public class ExcelUtiles {	
	public static String path;
	public static FileOutputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet s;
	public static XSSFSheet s2;
public static void excelInit() throws FileNotFoundException
{
	
	ExcelUtiles.path = System.getProperty("user.dir")+"\\ExcelData\\news.xlsx";
	ExcelUtiles.file = new FileOutputStream(path);
	ExcelUtiles.wb = new XSSFWorkbook();
	ExcelUtiles.s = ExcelUtiles.wb.createSheet("Upcoming Honda Bikes");
    ExcelUtiles.s2=ExcelUtiles.wb.createSheet("PopularBrands");
}
public static void saveBikesData(List<String> ModelNames, List<String> ExpectedPrice, List<String> ExpectedLaunch) throws FileNotFoundException {
			ExcelUtiles.excelInit();
		
					XSSFRow row1 = ExcelUtiles.s.createRow(0);
					row1.createCell(0).setCellValue("ModelName");
					row1.createCell(1).setCellValue("Expected Price");
					row1.createCell(2).setCellValue("ExpectedLaunchDate");
					for(int r=1;r<ModelNames.size()+1;r++) {

						XSSFRow row = ExcelUtiles.s.createRow(r);

						row.createCell(0).setCellValue(ModelNames.get(r-1));
						row.createCell(1).setCellValue(ExpectedPrice.get(r-1));
						row.createCell(2).setCellValue(ExpectedLaunch.get(r-1));
						}
					
					}

public static void SaveCarsData(List<String>PopularBrands) {
	XSSFRow row2 = ExcelUtiles.s2.createRow(0);
	row2.createCell(0).setCellValue("Popular Cars");
	for(int i=0;i<PopularBrands.size();i++) {
		XSSFRow row = ExcelUtiles.s2.createRow(i+1);
		row.createCell(0).setCellValue(PopularBrands.get(i));
	}
	
}
					

public static void closeExcel() throws IOException
	{

	ExcelUtiles.wb.write(file);

	ExcelUtiles.wb.close();

	ExcelUtiles.file.close();
	
	}

}
