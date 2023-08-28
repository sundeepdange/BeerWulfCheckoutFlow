package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LocalePage;
import pageObjects.ProductDetailsPage;

public class checkoutFlow extends TestBase {

	HomePage homePage;
	LocalePage localePage;
	ProductDetailsPage productDetailsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;

	public checkoutFlow() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		OpenBeerWulf();
		localePage = new LocalePage();
		homePage = new HomePage();
	}

	@Test
	public void checkoutflow() throws IOException {
		homePage = localePage.selectUKRegion();
		homePage.ageDisclaimer();
		homePage.acceptCookies();
		productDetailsPage = homePage.searchAndSelectDesiredProduct();
		cartPage = productDetailsPage.addSelectedProductToCart();
		checkoutPage = cartPage.gotoCheckout();
		checkoutPage.continueToCheckoutAsGuest();
		checkoutPage.enterPersonalDetails();
	}

	@AfterMethod
	public void tearDown() {
		cleanUp();
	}
}
