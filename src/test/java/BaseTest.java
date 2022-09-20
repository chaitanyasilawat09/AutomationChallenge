import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.ApplicationProperties;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseTest {

    public WebDriver driver = null;
    ApplicationProperties applicationProperties = ApplicationProperties.INSTANCE;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.logfile", "TestLog.txt");
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("file://"+System. getProperty("user.dir")+applicationProperties.getUrl());
        driver.manage().window().maximize();
        assertThat(driver.getTitle(), is(applicationProperties.getTitle()));
    }

    @AfterMethod
    public void teatDown() {
        driver.quit();
    }

}
