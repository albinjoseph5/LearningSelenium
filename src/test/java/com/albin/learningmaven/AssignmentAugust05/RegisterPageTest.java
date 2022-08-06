package com.albin.learningmaven.AssignmentAugust05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// Basic setup to begin with
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\Chrome Driver\\chromedriver.exe");

		// Opens up the browser
		driver = new ChromeDriver();

		// Load URL on the browser
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// Maximize the screen
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
		firstNameInputField.sendKeys("Albin");

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-lastname"));
		lastNameInputField.sendKeys("Joseph");

		WebElement emailInputField = driver.findElement(By.cssSelector("#input-email"));
		emailInputField.sendKeys("ajalbinjoseph@gmail.com");

		WebElement phoneNumberInputField = driver.findElement(By.cssSelector("#input-telephone"));
		phoneNumberInputField.sendKeys("4168418292");

		WebElement passwordInputField = driver.findElement(By.cssSelector("#input-password"));
		passwordInputField.sendKeys("Qwerty123");

		WebElement confirmPasswordInputField = driver.findElement(By.cssSelector("#input-confirm"));
		confirmPasswordInputField.sendKeys("Qwerty123");

		WebElement subscribeYesCheckBox = driver.findElement(By.cssSelector("label.radio-inline:nth-of-type(1) input"));
		subscribeYesCheckBox.click();

		WebElement continueBtn = driver.findElement(By.cssSelector("input.btn.btn-primary"));
		continueBtn.click();

		WebElement alertBanner = driver.findElement(By.cssSelector("div.alert"));
		String alertBannerText = alertBanner.getText();
		Assert.assertEquals(alertBannerText, "Warning: You must agree to the Privacy Policy!", "Text doesnot match");
	}

	@AfterMethod
	public void teardown() {
		// Close the browser
		driver.close();
	}

}
