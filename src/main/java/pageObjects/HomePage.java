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
 * This page lists all the page elements and methods needed for the Home page of the website 
 */

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/en-gb']")
	WebElement selectLocale;

	@FindBy(css = "a[id='eighteenTrigger']")
	WebElement ageConfirmYes;

	@FindBy(css = "input[id='header-search-input']")
	WebElement homePageSearchBox;

	@FindBy(css = "button[type='submit']")
	WebElement homePageSearchButton;

	@FindBy(css = "button[id='ensBtnYes']")
	WebElement cookiesConsentButton;

	@FindBy(css = "img[title='World of Beer Case']")
	WebElement linkToPDPageForSearchedProduct;

	public void ageDisclaimer() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(ageConfirmYes))
				.click();
	}

	public void acceptCookies() {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(cookiesConsentButton)).click();
	}

	public ProductDetailsPage searchAndSelectDesiredProduct() throws IOException {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(homePageSearchBox)).click();
		homePageSearchBox.sendKeys("world of beer case");
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(homePageSearchButton)).click();
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(linkToPDPageForSearchedProduct)).click();
		return new ProductDetailsPage();

	}

}
