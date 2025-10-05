package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.*;

public class Laptops_Page {

    // ===== Locators =====
    private final By dellLatitude = By.xpath("//h3[contains(text(),'Dell Latitude 7490')]");
    private final By searchBar = By.cssSelector("input[type='search'], input[placeholder*='Search']");
    private final By firstSearchResult = By.xpath("(//div[contains(@class,'items-start')]//div[contains(@class,'flex-1')]//a)[1]");
    private final By addToCartBtn = By.xpath("//*[@id='main']/div[2]/form/div/div/div[2]/div[6]/button");
    private final By descriptionLocator = By.id("descritpion-tab-button"); // typo kept because it's in DOM
    private final By plusBtn = By.cssSelector("span.icon-plus");

    // ===== Methods =====
    /**
     * Scroll to description, set quantity, and add item to cart
     * @param quantity number of items to add
     */
    public void addToCartWithQuantity(int quantity) {
        // Scroll to description section
        WebElement description = WaitUtils.waitForVisibility(descriptionLocator, 10);
        new Actions(BaseDriver.getDriver()).moveToElement(description).perform();

        // Increase quantity (only if > 1)
        if (quantity > 1) {
            WebElement plusButton = WaitUtils.waitForVisibility(plusBtn, 10);
            for (int i = 1; i < quantity; i++) {
                plusButton.click();
            }
        }

        // Click Add to Cart
        WebElement addBtn = WaitUtils.waitForClickability(addToCartBtn, 10);
        addBtn.click();
    }
}
