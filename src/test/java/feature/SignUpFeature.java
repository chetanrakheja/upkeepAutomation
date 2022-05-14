package feature;

import pages.SignUpPage;

public class SignUpFeature {
    SignUpPage signUpPage = new SignUpPage();

    public String signUp(String email, String password, String firstName, String lastName, String countryCode, String mobileNum, String companyName, String jobTitle) {
        signUpPage
                .gotoSignupPage()
                .enterEmail(email)
                .enterPassword(password)
                .enterFirstName(firstName)
                .enterLastName(lastName)
//                .selectCountryCode(countryCode)
                .enterMobileNum(mobileNum)
                .enterCompanyName(companyName)
                .enterJobTitle(jobTitle)
                .clickOnGetStarted();

        if (signUpPage.isErrorPanelVisible()) {
            return signUpPage.getErrorText();
        }
        if (signUpPage.isSignUpSuccess()) {
            return signUpPage.getSuccessSignupMessage();
        }
        return "";
    }



}
