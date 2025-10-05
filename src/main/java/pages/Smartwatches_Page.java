package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.*;

public class Smartwatches_Page {

    // ===== Locators =====

    // Locator for the description tab section (used to scroll page into view)
    private final By descriptionLocator = By.id("descritpion-tab-button");

    // Locator for the "+" button to increase quantity
    private final By plusBtn = By.cssSelector("span.icon-plus");

    // Locator for the "Add To Cart" button
    private final By addToCartBtn = By.cssSelector("button.secondary-button[type='submit']");

    // ===== Actions =====

    /**
     * Selects an Apple Watch with given configuration and adds it to the cart.
     *
     * @param connectivity e.g. "GPS And Cellular"
     * @param color        e.g. "Silver"
     * @param size         e.g. "44mm"
     * @param quantity     number of items to add (clicks "+" button if > 1)
     */
    public void selectAppleWatch(String connectivity, String color, String size, int quantity) {

        // 1. Select connectivity option dynamically
        By connectivityOption = By.xpath("//label[normalize-space()='" + connectivity + "']");
        WebElement connectivityEl = WaitUtils.waitForClickability(connectivityOption, 10);
        connectivityEl.click();

        // 2. Scroll to product description section to make sure options & buttons are visible
        WebElement description = WaitUtils.waitForVisibility(descriptionLocator, 10);
        Actions actions = new Actions(BaseDriver.getDriver());
        actions.moveToElement(description).perform();

        // 3. Select color dynamically
        By colorOption = By.xpath("//label[normalize-space()='" + color + "']");
        WebElement colorEl = WaitUtils.waitForClickability(colorOption, 10);
        colorEl.click();

        // 4. Select size dynamically
        By sizeOption = By.xpath("//label[normalize-space()='" + size + "']");
        WebElement sizeEl = WaitUtils.waitForClickability(sizeOption, 10);
        sizeEl.click();

        // 5. Adjust quantity if more than 1
        if (quantity > 1) {
            WebElement plusButton = WaitUtils.waitForVisibility(plusBtn, 10);
            for (int i = 1; i < quantity; i++) {
                plusButton.click();
            }
        }

        // 6. Finally, click "Add To Cart"
        WebElement addBtn = WaitUtils.waitForClickability(addToCartBtn, 10);
        addBtn.click();
    }
}
