package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public By increaseQuantity = By.cssSelector("div[class='quantity-button plus']");
	public By totalPrice = By.cssSelector("td[data-title='Total']>strong>span[class='woocommerce-Price-amount amount']");
	public By cartUpdatedAlert = By.cssSelector("div[class='woocommerce-message'][role='alert']");
	public By proceedToCheckout = By.cssSelector("div[class='wc-proceed-to-checkout']>a[class='checkout-button button alt wc-forward']");

}
