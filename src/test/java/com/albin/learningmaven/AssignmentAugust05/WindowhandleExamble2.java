package com.albin.learningmaven.AssignmentAugust05;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowhandleExamble2 {
	WebDriver driver;

	Actions ac;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void findElementsExample() {

		String parentWindowHandle = driver.getWindowHandle();
		String textFromNewTab;

		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("tabButton")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				textFromNewTab = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(textFromNewTab);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
