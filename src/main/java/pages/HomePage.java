package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='test-1-div']/h1")
    private WebElement test1Heading;

    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "dropdownMenuButton")
    private WebElement test3_DropdownButton;

    @FindBy(xpath = "//a[@class='dropdown-item' and text()='Option 3']")
    private WebElement test3_DropdownOption3;

    @FindBy(xpath = "//div[@id='test-4-div']/button[1]")
    private WebElement test4_FirstButton;

    @FindBy(xpath = "//div[@id='test-4-div']/button[2]")
    private WebElement test4_SecondButton;

    @FindBy(xpath = "//div[@id='test-5-div']/button")
    private WebElement test5_FirstButton;

    @FindBy(xpath = "//div[@id='test5-alert']")
    private WebElement test5_alertMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void signInUsingEmailAndPassword(String userName, String password) {

        clickOnElement(emailField);
        enterTextIntoField(emailField, userName);
        clickOnElement(passwordField);
        enterTextIntoField(passwordField, password);
        clickOnElement(submitButton);
    }

    public void clickOnDropDownButtonAndSelectOption3() {
        waitForVisibilityOfElement(test3_DropdownButton);
        clickOnElement(test3_DropdownButton);
        test3_DropdownOption3.click();
    }

    public String getValueFromTest2List(int listIndex) {
        waitForVisibilityOfElement(driver.findElement(By.xpath("//ul[@class='list-group']/li[" + listIndex + "]")));
        WebElement element = driver.findElement(By.xpath("//ul[@class='list-group']/li[" + listIndex + "]"));
        return element.getText();
    }

    public String getBadgeValueFromTest2List(int listIndex) {
        waitForVisibilityOfElement(driver.findElement(By.xpath("//ul[@class='list-group']/li[" + listIndex + "]/span")));
        WebElement element = driver.findElement(By.xpath("//ul[@class='list-group']/li[" + listIndex + "]/span"));
        return element.getText();
    }

    public void verifyButtonOnTest4() {
        waitForVisibilityOfElement(getTest4_FirstButton());
        waitForVisibilityOfElement(getTest4_SecondButton());
    }

    public void verifyButtonOnTest5AndClickOnIt() {
        waitForVisibilityOfElement(getTest5_FirstButton());
        getTest5_FirstButton().isEnabled();
        getTest5_FirstButton().click();
    }

    public String getValueFromTable(int row, int cell) {
        row++;
        cell++;
        waitForVisibilityOfElement(driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + cell + "]")));
        WebElement element = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + cell + "]"));
        return element.getText();
    }
}
