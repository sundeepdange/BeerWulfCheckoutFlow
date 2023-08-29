package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

/*
 * This page lists all the page elements and methods needed for the checkout page
 */

public class CheckoutPage extends TestBase {

	public CheckoutPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class='bw-btn primary-md']")
	WebElement continueToCheckoutButton;

	@FindBy(css = "input[name='CheckoutForm.AddressFormWrapper.EmailAddress']")
	WebElement enterEmailTextBox;

	@FindBy(css = "input[name='CheckoutForm.AddressFormWrapper.PhoneNumber']")
	WebElement enterPhoneNumberTextBox;

	@FindBy(css = "input[id='CheckoutForm_AddressFormWrapper_ShippingAddress_Firstname']")
	WebElement enterFirstNameTextBox;

	@FindBy(css = "input[id='CheckoutForm_AddressFormWrapper_ShippingAddress_Lastname']")
	WebElement enterLastNameTextBox;

	@FindBy(css = "input[name='CheckoutForm.AddressFormWrapper.ShippingAddress.AddressLine1']")
	WebElement enterAddressTextBox;

	@FindBy(css = "input[name='CheckoutForm.AddressFormWrapper.ShippingAddress.CityName']")
	WebElement enterCityTextBox;

	@FindBy(css = "input[id='CheckoutForm_AddressFormWrapper_ShippingAddress_PostalCode']")
	WebElement enterPostCodeTextBox;

	@FindBy(css = "input[id='submitStep1']")
	WebElement personalDetailsNextButton;

	@FindBy(css = "input[id='submitStep2']")
	WebElement selectPaymentTypeNextButton;

	@FindBy(css = "input[id='submitStep3']")
	WebElement orderReviewNextButton;

	@FindBy(css = "label[for='DrinkingAge']")
	WebElement drinkingAgeCheckBox;

	@FindBy(css = "input[id='CheckoutForm_AddressFormWrapper_ShippingAddress_RegionName']")
	WebElement regionNameTextBox;

	public void continueToCheckoutAsGuest() {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(continueToCheckoutButton)).click();
	}

	public void enterPersonalDetailsAndCompleteCheckout() throws IOException {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterEmailTextBox)).click();
		enterEmailTextBox.sendKeys("testuser@test.com");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterPhoneNumberTextBox)).click();
		enterPhoneNumberTextBox.sendKeys("0231456987");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterFirstNameTextBox)).click();
		enterFirstNameTextBox.sendKeys("John");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterLastNameTextBox)).click();
		enterLastNameTextBox.sendKeys("Doe");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterAddressTextBox)).click();
		enterAddressTextBox.sendKeys("London Colney");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterCityTextBox)).click();
		enterCityTextBox.sendKeys("London");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(enterPostCodeTextBox)).click();
		enterPostCodeTextBox.sendKeys("AL2 1DR");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(regionNameTextBox)).click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,1500)");

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(personalDetailsNextButton)).click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(selectPaymentTypeNextButton)).click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(drinkingAgeCheckBox)).click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(orderReviewNextButton)).click();

		// Verify that the checkout flow is on the payment details page
		String paymentPageUrl = driver.getCurrentUrl(); 
		Assert.assertTrue(paymentPageUrl.contains("paymentMethod=payWithStripe"));
	}
}
