package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class PretzelsPage extends SeleniumWrappers{
	
	public PretzelsPage(WebDriver driver) {
		super(driver);
	}
	
	public By addToCartButton = By.cssSelector("button[name='add-to-cart']"); 
	public By productAddedToCartMessage = By.cssSelector("div[class='woocommerce-message'][role='alert']"); 

}
