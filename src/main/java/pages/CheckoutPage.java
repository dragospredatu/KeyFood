package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public By placeOrderButton = By.cssSelector("button[type='submit'][id='place_order']");
	public By acceptTermsAndConditionsCheckbox = By.cssSelector("input[type='checkbox'][id='terms']");
	public By orderReceivedConfirmation = By.cssSelector("p[class*='order-received']");
	public By orderNumber = By.cssSelector("li[class='woocommerce-order-overview__order order']");

}
