package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

/**
 * Page Object for the Login Page.
 * Encapsulates locators and actions related to user login.
 */
public class Login_Page {

    // ===== Locators =====
    private final By emailField = By.id("identifier");   // Email input field
    private final By passwordField = By.id("password");  // Password input field

    // ===== Actions =====
    /**
     * Full login flow using email and password.
     * @param email    user email
     * @param password user password
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    /**
     * Enter email in the email input field.
     * @param email user email
     */
    private void enterEmail(String email) {
        WebElement emailInput = WaitUtils.waitForVisibility(emailField, 10);
        emailInput.clear();
        emailInput.sendKeys(email, Keys.ENTER);
    }

    /**
     * Enter password in the password input field.
     * @param password user password
     */
    private void enterPassword(String password) {
        WebElement passwordInput = WaitUtils.waitForVisibility(passwordField, 10);
        passwordInput.clear();
        passwordInput.sendKeys(password, Keys.ENTER);
    }
}
