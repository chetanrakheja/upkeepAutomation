package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class SignOutTest extends BaseTest {

    @Test
    public void PositiveLogOut(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        loginPage.gotoLoginPg().enterUserName("rakhejachetan.dev@gmail.com")
                .enterPassword("Chetan@1234").clickOnLoginBtn();
        homePage
                .clickOnSettingsBtn()
                .clickOnLogOut()
                .clickOnLogOutOK();


    }


}
