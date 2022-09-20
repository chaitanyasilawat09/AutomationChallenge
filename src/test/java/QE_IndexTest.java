import dataProvider.DataProviderForSearchProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class QE_IndexTest extends BaseTest {

    HomePage homePage = null;

    @BeforeMethod
    public void beforeTest(){
        homePage = new HomePage(driver);
    }

    @Test(dataProvider = "testDPMultipleData", dataProviderClass = DataProviderForSearchProperties.class)
    public void Test1(String userName, String password){

        assertThat(homePage.getEmailField().isDisplayed(), is(true));
        assertThat(homePage.getPasswordField().isDisplayed(), is(true));
        assertThat(homePage.getSubmitButton().isDisplayed(), is(true));

        homePage.signInUsingEmailAndPassword(userName, password);

    }

    @Test()
    public void Test2(){

        assertThat(homePage.getValueFromTest2List(2).trim(), containsString("List Item 2"));
        assertThat(homePage.getBadgeValueFromTest2List(2).trim(), is("6"));
    }

    @Test()
    public void Test3(){

        assertThat(homePage.getTest3_DropdownButton().getText(), containsString("Option 1"));

        homePage.clickOnDropDownButtonAndSelectOption3();

        assertThat(homePage.getTest3_DropdownButton().getText(), containsString("Option 3"));

    }

    @Test()
    public void Test4(){

        homePage.verifyButtonOnTest4();

        assertThat(homePage.getTest4_FirstButton().isEnabled(), is(true));
        assertThat(homePage.getTest4_SecondButton().isEnabled(), is(false));
    }

    @Test()
    public void Test5(){

        homePage.verifyButtonOnTest5AndClickOnIt();

        assertThat(homePage.getTest5_alertMessage().getText().trim(), is("You clicked a button!"));
        assertThat(homePage.getTest5_FirstButton().isEnabled(), is(false));
    }

    @Test()
    public void Test6(){

        String cellValue = homePage.getValueFromTable(2,2);

        assertThat(cellValue, is("Ventosanzap"));
    }
}
