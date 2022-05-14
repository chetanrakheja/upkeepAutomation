package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseTest;


public class FirstPage extends BaseTest {
//    TestUtils utils = new TestUtils();

    @AndroidFindBy(id="button_sign_up")
    WebElement signUpBtn;

    @AndroidFindBy(id="ll_log_in")
    WebElement logInBtn;

    public FirstPage clickOnLogin(){
        click(logInBtn);
        return this;
    }

    public FirstPage clickOnSignUp(){
        click(signUpBtn);
        return this;
    }


}
