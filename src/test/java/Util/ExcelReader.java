package Util;



	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader 
	{
		
		 public String path;
		public FileInputStream fis;
		public XSSFWorkbook wb;
		public XSSFSheet sheet;
		public XSSFRow row;
		public XSSFCell cell;

		public ExcelReader(String path,String sheetName) throws IOException
		{
			this.path=path;
			fis=new FileInputStream(path);
			System.out.println(sheetName);
			wb=new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		}
		
		public int getRowCount() throws IOException
		{
		  int rowcount=sheet.getLastRowNum();
		
			return rowcount;	
		}
		
		public int getCellCount(int rownum) throws IOException
		{
			row=sheet.getRow(rownum);
			    int cellcount = row.getLastCellNum();
			   
			return cellcount;
			
		}
		
		public String getCelldata(int rownum,int colnum) throws IOException
		{
			 row=sheet.getRow(rownum);
			 cell=row.getCell(colnum);
			 DataFormatter formatter = new DataFormatter();
				String data;
				try{
				data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
				}
				catch(Exception e)
				{
					data="";
				}
				wb.close();
				fis.close();
				return data;	
		}
		
		
		
		
		
		
		
		
		
		
	

}
