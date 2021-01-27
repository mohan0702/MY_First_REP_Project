package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Basic {

	@BeforeTest
	public void openBrowser() {
		System.out.println("...openBrwser...");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("...closeBrwser...");

	}

	@BeforeClass
	public void login() {
		System.out.println("...login...");

	}

	@AfterClass
	public void logout() {
		System.out.println("...logout...");

	}
}
