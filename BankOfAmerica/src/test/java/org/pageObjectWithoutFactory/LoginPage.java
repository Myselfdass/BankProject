package org.pageObjectWithoutFactory;

import org.baseUtils.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass{


	@BeforeTest
	private void initialization() {
		browserLaunch("firefox");
		launchUrl("http://adactinhotelapp.com/");

	}
	@Test(groups = "Dass",priority = 1)
	private void testCase1() {
		input(By.xpath("//input[@name=\"username\"]"), "1539086");
		input(By.xpath("//input[@id=\"password\"]"), "Das@454");
		clickOption(By.xpath("//input[@class=\"login_button\"]"));

	}

	@AfterTest
	private void browserClose() {
		closeDriver();
	}




}
