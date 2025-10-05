package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;

// Page Object for Home Page
public class Home_Page {
    private WebDriver driver;

    // Locators
    private final By headerLocator = By.cssSelector("header"); // page header
    private final By accountIcon = By.xpath("//span[contains(text(),'Account')]"); // account menu
    private final By signInButton = By.xpath("//a[contains(text(),'Sign In')]"); // sign in link
    
    private final By countryDropdownArrow = By.cssSelector("div.relative.flex-shrink-0.inline-block.group.leading-none.cursor-pointer > button > svg"); // country dropdown
    private final By uaeOption = By.xpath("//span[text()='UAE']"); // UAE option

    private final By laptopslocator = By.cssSelector("a[href*='/laptops']"); // laptops tab
    private final By samrtWatchesLocator = By.cssSelector("a[href*='smartwatches']"); // smartwatches tab
    
    private final By searchBar = By.cssSelector("input[type='search'], input[placeholder*='Search']"); // search input
    private final By firstSearchResult = By.xpath("(//div[contains(@class,'items-start')]//div[contains(@class,'flex-1')]//a)[1]"); // first result link

    // Constructor - opens the given URL and maximizes window
    public Home_Page(WebDriver driver, String url) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    // Select UAE country
    public void selectUAE() {
        WaitUtils.waitForClickability(countryDropdownArrow, 10).click();
        WaitUtils.waitForClickability(uaeOption, 10).click();
    }

    // Quit browser
    public void QuitBrowser() {
        driver.quit();
    }

    // Go to login page
    public void goToLogin() {
        WaitUtils.waitForClickability(accountIcon, 10).click();
        WaitUtils.waitForClickability(signInButton, 10).click();
    }

    // Open laptops section
    public void clickLaptopsTab() {
        WaitUtils.waitForVisibility(laptopslocator, 10).click();
    }

    // Open smartwatches section
    public void clickSmartwatchesTab() {
        WaitUtils.waitForVisibility(samrtWatchesLocator, 10).click();
    }
    
    // Search for an item and press Enter
    public void searchItem(String item) {
        WebElement searchInput = WaitUtils.waitForVisibility(searchBar, 10);
        searchInput.clear();
        searchInput.sendKeys(item);
        searchInput.sendKeys(Keys.ENTER);
    }

    // Click the first search result
    public void clickFirstSearchResult() {
        WebElement firstResult = WaitUtils.waitForVisibility(firstSearchResult, 10);
        firstResult.click();
    }
    
    // Scroll to header using Actions
    public void scrollToHeader() {
        WebElement header = driver.findElement(headerLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();
    }
}
