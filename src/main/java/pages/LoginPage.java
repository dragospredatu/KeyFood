package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public By usernameField = By.cssSelector("input[id='username']");
	public By passwordField = By.cssSelector("input[id='password']");
	public By submitButton = By.cssSelector("button[type='submit']");

	public void loginInApp(String username, String password) {
		
		sendKeys(usernameField, username);
		sendKeys(passwordField, password);
		click(submitButton);
	}
}
