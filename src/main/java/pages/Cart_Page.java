package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

// Page Object for Cart Page
public class Cart_Page {

    // Locators
    private final By viewCartBtn = By.cssSelector("header .style2Header span span:nth-child(2)"); // cart icon
    private final By viewCartLocator = By.cssSelector("a.cursor-pointer.text-gray-700.border-gray-300.hover\\:text-navyBlue"); // "View Cart" link
    private final By firstRemoveBtn = By.xpath("(//span[@role='button']//span[normalize-space()='Remove'])[1]"); // remove first item
    private final By removeAgreeButtonLocator = By.cssSelector("button.primary-button"); // confirm remove
    private final By checkoutBtn = By.cssSelector("a.primary-button[href*='checkout']"); // checkout button

    // Open Cart Page
    public void openCart() {
        WaitUtils.waitForVisibility(viewCartBtn, 10).click();
        WaitUtils.waitForVisibility(viewCartLocator, 10).click();
    }

    // Remove first laptop/item from cart
    public void removeLaptop() {
        WaitUtils.waitForVisibility(firstRemoveBtn, 10).click();
        System.out.println("Clicked the 'Remove' button.");
        WaitUtils.waitForVisibility(removeAgreeButtonLocator, 10).click();
        System.out.println("Clicked the 'Agree' confirmation button.");
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        WaitUtils.waitForVisibility(checkoutBtn, 10).click();
    }
}
