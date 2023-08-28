package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

/*
 * This page lists all the page elements and methods needed for the shopping cart  page
 * 
 */
public class CartPage extends TestBase {

	public CartPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/en-gb/my-account/LoginCheckout']")
	WebElement goToCheckoutPageButton;

	public CheckoutPage gotoCheckout() throws IOException {
		
		String currentUrl=driver.getCurrentUrl(); 
		Assert.assertTrue(currentUrl.contains("/en-gb/cart"));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(goToCheckoutPageButton)).click();
		return new CheckoutPage();
	}

}
