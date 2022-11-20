package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{
		
	public NavMenuPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	public By myAccountLink = By.linkText("My account");
	public By searchField = By.cssSelector("input[type='search']");
	public By pretzels = By.cssSelector("h3[class='product-title']>a");
	public By cartIcon = By.cssSelector("div[class='header-cart button-item bordered']");
	public By viewCartButton = By.xpath("//p[@class='woocommerce-mini-cart__buttons buttons']//a[1]");
	
	//Methods
	public void navigateTo(By locator) {
		
		driver.findElement(locator).click();
	}
	
	
	public void searchProduct(String value) {
		
		sendKeys(searchField, value);
	}

}
