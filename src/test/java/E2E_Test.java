import utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

public class E2E_Test {
    private WebDriver driver;
    private Home_Page homePage;
    private Login_Page loginPage;
    private Laptops_Page laptopsPage;
    private Smartwatches_Page smartwatchesPage;
    private Cart_Page cartPage;

    @BeforeClass
    public void setUp() {
        System.out.println("START OF THE E2E TEST");
        // Initialize Chrome driver
        driver = BaseDriver.initializeDriver("chrome");

        // Initialize page objects
        homePage = new Home_Page(driver, "https://cartlow.com/intl/en");
        loginPage = new Login_Page();
        laptopsPage = new Laptops_Page();
        smartwatchesPage = new Smartwatches_Page();
        cartPage = new Cart_Page();
    }

    @Test
    public void E2E_AutomationScenario() {

        // ===== Login flow =====
        homePage.goToLogin();
        loginPage.login("ot140018@gmail.com", "Osama123@");  // Enter credentials
        homePage.selectUAE();  // Select UAE store

        // ===== Laptop flow =====
        homePage.clickLaptopsTab(); // Open Laptops category
        homePage.searchItem("Dell Latitude 7490 Intel Core i7-8650U 14\" FHD Display, 16GB RAM, 512GB SSD, Windows 10 Pro");
        homePage.clickFirstSearchResult(); // Open first laptop search result
        laptopsPage.addToCartWithQuantity(1); // Add 1 laptop to cart
        homePage.scrollToHeader(); // Scroll back up

        // ===== Smartwatch flow =====
        homePage.clickSmartwatchesTab(); // Open Smartwatches category
        homePage.searchItem("Apple Watch Series 6 (40mm, GPS + Cellular) Gold Aluminum Case with Pink Sand Sport Band");
        homePage.clickFirstSearchResult(); // Open first smartwatch search result
        smartwatchesPage.selectAppleWatch("GPS And Cellular", "Silver", "44mm", 2); // Configure and add 2 watches
        homePage.scrollToHeader(); // Scroll back up

        // ===== Cart flow =====
        cartPage.openCart();       // Go to cart
        cartPage.removeLaptop();   // Remove laptop from cart
        cartPage.proceedToCheckout(); // Proceed to checkout
   
    }

    @AfterClass
    public void tearDown() {
        System.out.println("END OF THE E2E TEST");
        BaseDriver.quitDriver(); // Quit browser after test
    }
}
