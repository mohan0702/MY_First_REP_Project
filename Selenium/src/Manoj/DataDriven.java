package Manoj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDriven {

	public static void main(String[] args) throws Exception {

		/*
		 * File src=new File("E:\\SELENIUMFEB2018\\DataDriven.xlsx"); FileInputStream
		 * fil =new FileInputStream(src); XSSFWorkbook wb=new XSSFWorkbook(fil);
		 * XSSFSheet ws=wb.getSheet("Sheet1");
		 * 
		 * Row rs; for(int r=0;r<=ws.getLastRowNum();r++) { rs=ws.getRow(r); for(int
		 * c=0;c<=rs.getLastCellNum();c++) {
		 * System.out.println(rs.getCell(0).getStringCellValue());
		 * System.out.println("   "); }
		 */

		
		
		FirefoxDriver driver = new FirefoxDriver();

		File src = new File("E:\\SELENIUMFEB2018\\DataDriven.xlsx");
		FileInputStream fil = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet ws = wb.getSheet("Sheet1");

	int z = ws.getLastRowNum();
		
		

	   // for(int row = 0;row <= s.getRows();row++){

		System.out.println("no of Users:" + z);
		for (int row = 0; row < z; row++) {
		
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	

			String username = ws.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Username: " + username);
			driver.findElement(By.id("identifierId")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='identifierNext']//div[2]")).click();
			Thread.sleep(2000);
			String password = ws.getRow(0).getCell(1).getStringCellValue();
			System.out.println("Password: " + password);
			driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
			driver.quit();
			/*
			 * 
			 * driver.findElement(By.
			 * xpath("/html[@class=' js opacity generatedcontent pointerevents']/body[@class='page-homepage pageType-ContentPage template-pages-layout-RexelHomePageLayout pageLabel-homepage language-de ']/div[@id='page']/div[@id='content']/div[@id='content']/div[@class='content-top-inner']/div[@id='content-inner']/div[@class='mid-wrapper'][1]/div[@class='yCmsContentSlot']/div[@class='login clear']/form[@id='loginForm']/div[@class='left sign-in']/button[@class='Sign-in rx-btn mb0']"
			 * )).click();
			 * 
			 * if(driver.getPageSource().contains("Willkommen")) {
			 * System.out.println("Login Sucessfull"); } else {
			 * System.out.println("Login Failed"); }
			 * 
			 * driver.quit();
			 */
		}
	}

}
