package Util;


	

	import java.io.IOException;


	import org.testng.annotations.DataProvider;

	public class DataProviders 
	{

		@DataProvider(name="LoginData")
		public String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"\\Testdata\\Testdata\\TestDataLogin.xlsx";
			System.out.println(path);
			ExcelReader exceldata=new ExcelReader(path,"AccountCreationData");
			int totalrows=exceldata.getRowCount();	
			System.out.println(totalrows);
			
			int totalcols=exceldata.getCellCount(5);
			System.out.println(totalcols);
			
			String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store the data user and password
			
			for (int i=1;i<totalrows;i++)//read the data from xl storing in two deminsional array
			{
				for (int j=0;j<totalcols;j++)//0    i is rows j is col
				{
					logindata[i][j]=exceldata.getCelldata( i, j);//1,0
				}
			}
			return logindata;

		
	}

}
