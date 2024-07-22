// ProductPage.java
package assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(id = "button-cart")
    WebElement addToCartBtn;

    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public void goToCart() {
        shoppingCartLink.click();
    }
}