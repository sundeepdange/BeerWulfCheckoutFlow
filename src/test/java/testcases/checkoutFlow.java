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



/*This is a test script for checkout flow on the beerwulf website 
 * Author: Sundeep Dange
 *  
 *  Steps: 
 *1. Open the https://www.beerwulf.com/ in Chrome 
 *2. Select locale/region 
 *3. Handle the age consent and cookie preference popups 
 *4. Search for desired product 
 *5. Select product and go to product details page
 *6. Add product to the cart and goto cart
 *7. Goto checkout page and continue as guest checkout 
 *8. Enter user details and select payment options [Credit card is selected by default]
 *9. Order review page is displayed, check the age consent checkbox and select Next to go to payments page
 *10. Payment page is displayed
 *
 */
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
		checkoutPage.enterPersonalDetailsAndCompleteCheckout();
	}

	@AfterMethod
	public void tearDown() {
		cleanUp();
	}
}
