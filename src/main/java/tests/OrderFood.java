package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.NavMenuPage;
import pages.PretzelsPage;
import utils.BaseTest;

public class OrderFood extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void orderFood(String username, String password) throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.myAccountLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, password);
		navMenu.searchProduct("Pretzels");
		//navMenu.waitForElementToBeClickable(driver.findElement(navMenu.pretzels));  -> nu am reusit sa localizez corect elementul pentru a naviga catre pagina
		//navMenu.click(navMenu.pretzels);
		driver.get("https://keyfood.ro/product/rold-gold-tiny-twists-pretzels/");
		PretzelsPage pretzelsPage = new PretzelsPage(driver);
		pretzelsPage.click(pretzelsPage.addToCartButton);
		pretzelsPage.waitForElementToBeVisible(driver.findElement(pretzelsPage.productAddedToCartMessage));
		assertTrue(driver.findElement(pretzelsPage.productAddedToCartMessage).getText().contains("“Rold Gold Tiny Twists Pretzels” has been added to your cart."));
		navMenu.hoverElement(navMenu.cartIcon);
		navMenu.hoverElement(navMenu.viewCartButton);
		navMenu.click(navMenu.viewCartButton);
		CartPage cartPage = new CartPage(driver);
		double initialTotalPrice = Double.parseDouble(driver.findElement(cartPage.totalPrice).getText().substring(1));
		cartPage.click(cartPage.increaseQuantity);
		cartPage.waitForElementToBeVisible(driver.findElement(cartPage.cartUpdatedAlert));
		double finalTotalPrice = Double.parseDouble(driver.findElement(cartPage.totalPrice).getText().substring(1));
		assertTrue(initialTotalPrice < finalTotalPrice, "The total price was not updated!");
		cartPage.click(cartPage.proceedToCheckout);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.click(checkoutPage.acceptTermsAndConditionsCheckbox);
		checkoutPage.click(checkoutPage.placeOrderButton);
		checkoutPage.waitForElementToBeVisible(driver.findElement(checkoutPage.orderReceivedConfirmation));
		assertEquals(checkoutPage.getElement(checkoutPage.orderReceivedConfirmation).getText(),"Thank you. Your order has been received.");
		assertTrue(checkoutPage.getElement(checkoutPage.orderNumber).getText().contains("Order number"));
	}
}