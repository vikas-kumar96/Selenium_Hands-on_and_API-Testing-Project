// AssessmentTest.java
package assessment.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import assessment.pages.*;

public class AssessmentTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        driver.manage().window().maximize();
	    Thread.sleep(3000);
    }

    @Test
    public void testSearchAndAddToCart() {
        loginPage.login("vikasbhatam9643@gmail.com", "Cdsco@12");
        homePage.searchProduct("iPhone");
        productPage.addToCart();
        productPage.goToCart();
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
