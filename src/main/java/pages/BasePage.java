package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf((element)));
        element.isDisplayed();
        mouseHover(element);
        element.isEnabled();
        element.click();

    }

    public void enterTextIntoField(WebElement element, String inputValues) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf((element)));
        element.isDisplayed();
        mouseHover(element);
        element.sendKeys(inputValues);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf((element)));
        if (element.isDisplayed()) {
            mouseHover(element);
            assertTrue(true, "Element is visible");
        } else
            assertFalse(false, "Element is not visible");
    }

    public void mouseHover(WebElement element) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
