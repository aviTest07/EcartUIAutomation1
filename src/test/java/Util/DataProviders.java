package Util;


	import java.io.IOException;


	import org.testng.annotations.DataProvider;

	public class DataProviders 
	{

		String path=System.getProperty("user.dir")+"\\TestData\\TestDataLogin.xlsx";
		
		
		@DataProvider(name="LoginData")
		public String[][] getData() throws IOException
		{
			System.out.println(path);
			ExcelReader exceldata=new ExcelReader(path,"AccountCreationData");
			int totalrows=exceldata.getRowCount();	
			System.out.println(totalrows);
			int totalcols=exceldata.getCellCount(totalrows);
			System.out.println(totalcols);
			String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store the data user and password
			
			for (int i=1;i<totalrows;i++)//read the data from xl storing in two deminsional array
			{
				for (int j=0;j<totalcols;j++)//0   i is rows j is col
				{
					logindata[i][j]=exceldata.getCelldata(i,j);//1,0
				}
			}
			return logindata;
		}
		@DataProvider(name="verifylogincredntials")
		public String[][] checkLogincred() throws IOException
		{
			ExcelReader exceldata=new ExcelReader(path,"TestCredentials");
			int totalrows=exceldata.getRowCount();	
			System.out.println(totalrows);
			int totalcols=exceldata.getCellCount(totalrows-1);
			System.out.println(totalcols);
			String loginCred[][]=new String[totalrows][totalcols]; //created for two dimension array which can store the data user and password
			for (int i=1;i<totalrows;i++)//read the data from xl storing in two deminsional array
			{
				for (int j=0;j<totalcols;j++)//0    i is rows j is col
				{
					loginCred[i][j]=exceldata.getCelldata(i,j);//1,0
				}
			}
			return loginCred;
		}
		}
			
	
