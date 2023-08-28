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
 * This page lists all the page elements and methods needed for the product details page
 */

public class ProductDetailsPage extends TestBase {

	public ProductDetailsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[id='addToCartContainer'] button[class='bw-btn primary-md plus textual']")
	WebElement addToCartButton;

	@FindBy(css = "a[href='/en-gb/cart']")
	WebElement goToCartButton;

	public CartPage addSelectedProductToCart() throws IOException {

		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addToCartButton))
				.click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(goToCartButton))
				.click();
		return new CartPage();
	}
}
