package RAMMOHAN;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenReadExcelwithdifferentdata {

	public void TestCase() throws Exception {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		driver.manage().window().maximize();
		ArrayList<String> username=ExcelReading(0);
	//	ArrayList<String> password=ExcelReading(1);
		
		for(int i=0;i<=username.size();i++)
		{
			
			driver.findElement(By.id("identifierId")).sendKeys(username.get(i));
			driver.findElement(By.xpath(".//*[@id='identifierNext']//div[2]")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password.get(i));
			Thread.sleep(10000);
			driver.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
			Thread.sleep(120000);
			driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click();
			driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
		
		}
		
		
	}

	public ArrayList<String> ExcelReading(int celNO) throws Exception {
		File fi = new File("E:\\SELENIUMFEB2018\\DataDriven.xlsx");
		FileInputStream fil = new FileInputStream(fi);
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet s = wb.getSheet("Sheet1");
		Iterator<Row> rowierator = s.iterator();
		rowierator.next();

		ArrayList<String> Arylist = new ArrayList<String>();

		while (rowierator.hasNext()) {

			Arylist.add(rowierator.next().getCell(celNO).getStringCellValue());

		}
		System.out.println(Arylist);
		return Arylist;

	}

	public static void main(String[] args) throws Exception {

		DataDrivenReadExcelwithdifferentdata data = new DataDrivenReadExcelwithdifferentdata();
		data.TestCase();

	}

}
