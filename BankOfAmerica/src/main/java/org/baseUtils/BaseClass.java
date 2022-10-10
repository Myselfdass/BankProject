package org.baseUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions actions = new Actions(driver);
	public static TakesScreenshot takes = (TakesScreenshot) driver;

	public void browserLaunch(String searchEngine) {
		if (searchEngine.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (searchEngine.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (searchEngine.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void input(By by,String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void clickOption(By by) {
		driver.findElement(by).click();

	}
	public void impliWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void closeDriver() {
driver.close();
	}
	public void quitDriver() {
driver.quit();
	}
	
	public void mouseHoveringActions(By by) {
		WebElement findElement = driver.findElement(by);
		actions.moveToElement(findElement).perform();

	}
	public void mouseClick(By by) {
		WebElement findElement = driver.findElement(by);
		actions.click(findElement).perform();
	}
	public void takesScreen(String name) {
		File screenshotAs = takes.getScreenshotAs(OutputType.FILE);
		try {
		File file = new File("C:\\Users\\91971\\eclipse-workspace\\BankOfAmerica\\target"+name);
		FileUtils.copyFile(screenshotAs, file);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
