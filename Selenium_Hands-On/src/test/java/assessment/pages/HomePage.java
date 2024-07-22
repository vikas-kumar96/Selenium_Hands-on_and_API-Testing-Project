// HomePage.java
package assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBtn.click();
    }
}


