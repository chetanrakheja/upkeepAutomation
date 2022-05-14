package feature;

import org.apache.commons.logging.Log;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginFeature {

    LoginPage loginPage = new LoginPage();

    public void login(String username, String password) {
        loginPage
                .gotoLoginPg()
                .enterUserName(username)
                .enterPassword(password)
                .clickOnLoginBtn();
    }

}
