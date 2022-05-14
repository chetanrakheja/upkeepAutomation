package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class LoginPage extends BaseTest {
    @AndroidFindBy(id="edit_text_username")
    private WebElement usernameField;

    @AndroidFindBy(id="edit_text_password")
    private  WebElement passwordField;

    @AndroidFindBy(id="login_button")
    private WebElement loginBtn;

    @AndroidFindBy(id="ll_log_in")
    private WebElement HomePgLoginBtn;

    public LoginPage gotoLoginPg(){
//        FirstPage firstPage = new FirstPage();
//        firstPage.clickOnLogin();
        click(HomePgLoginBtn);
//        HomePgLoginBtn.click();
        return this;
    }
    public LoginPage clickOnLoginBtn(){
//        loginBtn.click();
        click(loginBtn);
        return this;
    }


    public LoginPage enterUserName(String username){
//        clear(emailTextField);
        sendKeys(usernameField,username);
//        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        click(passwordField);
        sendKeys(passwordField,password);
//        passwordField.click();
//        passwordField.sendKeys(password);
        return this;
    }


}
