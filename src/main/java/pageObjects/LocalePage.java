package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

/*
 * This page lists all the page elements and methods needed for the locale/region selection page
 */

public class LocalePage extends TestBase {

	public LocalePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/en-gb']")
	WebElement selectUKRegion;

	public HomePage selectUKRegion() throws IOException {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(selectUKRegion))
				.click();
		return new HomePage();
	}
}
