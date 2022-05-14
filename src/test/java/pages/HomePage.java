package pages;

import feature.LoginFeature;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class HomePage extends BaseTest {


    @AndroidFindBy(id="bottom_nav_center")
    private WebElement addButton;

    @AndroidFindBy(id="action_settings")
    private WebElement settingsBtn;

    @AndroidFindBy(id="rl_logout")
    private WebElement logOutBtn;

//    @AndroidFindBy(id="button1")
    @AndroidFindBy(xpath="//*[@text='OK']")
    private WebElement logOutOKBtn;

//    @AndroidFindBy(id="button2")
    @AndroidFindBy(xpath = "//*[@text='CANCEL']")
    private WebElement logOutCancelBtn;


    public HomePage clickOnSettingsBtn(){
        click(settingsBtn);
        return this;
    }
    public HomePage clickOnLogOut(){
        click(logOutBtn);
        return this;
    }
    public HomePage clickOnAddBtn(){
        click(addButton);
        return this;
    }

    public HomePage clickOnLogOutOK(){
        click(logOutOKBtn);
        return this;
    }

    public HomePage clickOnLogOutCancel(){
        click(logOutCancelBtn);
        return this;
    }

    public HomePage gotoHomePageAfterLogin(String username, String password){
//        LoginFeature loginFeature = new LoginFeature();
//        loginFeature.login(username,password);
        LoginPage loginPage = new LoginPage();
        loginPage
                .gotoLoginPg()
                .enterUserName(username)
                .enterPassword(password)
                .clickOnLoginBtn();
        return this;
    }

}
