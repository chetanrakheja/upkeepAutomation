package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class SignUpPage extends BaseTest {

    @AndroidFindBy(id="edit_text_email")
    WebElement emailTextField;

    @AndroidFindBy(id="edit_text_password")
    WebElement passwordField;

    @AndroidFindBy(id="edit_text_first_name")
    WebElement fName;

    @AndroidFindBy(id="edit_text_last_name")
    WebElement lName;

    @AndroidFindBy(id="rlClickConsumer")
    WebElement countryCodeSelect;

    @AndroidFindBy(id="editText_search")
    WebElement countrySearch;

    @AndroidFindBy(id="edit_text_phone_number")
    WebElement mobileNumField;

    @AndroidFindBy(id="edit_text_company_name")
    WebElement companyName;

    @AndroidFindBy(id="edit_text_job_title")
    WebElement jobTitle;

    @AndroidFindBy(id="button_signup")
    WebElement getStartedBtn;

    @AndroidFindBy(id="parentPanel")
    WebElement errorPanel;

    @AndroidFindBy(id="button1")
    WebElement errorPanelOkBtn;

    @AndroidFindBy(id="message")
    WebElement errorPanelText;

    @AndroidFindBy(id="tv_title")
    WebElement successSignUp;

    @AndroidFindBy(id="button_sign_up")
    WebElement signUpBtn;

    public SignUpPage gotoSignupPage(){
//        HomePage homePage = new HomePage();
//        homePage.clickOnSignUp();
        click(signUpBtn);
        return this;

    }

    public SignUpPage enterEmail(String email){
//        clear(emailTextField);
        sendKeys(emailTextField,email);
        return this;
    }

    public SignUpPage enterPassword(String password){
//        clear(passwordField);
        sendKeys(passwordField,password);
        return this;
    }

    public SignUpPage enterFirstName(String firstName){
//        clear(fName);
        sendKeys(fName,firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName){
//        clear(lName);
        sendKeys(lName,lastName);
        return this;
    }
    public SignUpPage enterMobileNum(String mobileNum){
//        clear(mobileNumField);
        sendKeys(mobileNumField,mobileNum);
        return this;
    }
    public SignUpPage enterCompanyName(String companyNameStr){
//        clear(companyName);
        sendKeys(companyName,companyNameStr);
        return this;
    }

    public SignUpPage enterJobTitle(String jobTitleStr){
//        clear(jobTitle);
        sendKeys(jobTitle,jobTitleStr);
        return this;
    }
    public SignUpPage clickOnGetStarted(){
        click(getStartedBtn);
        return this;
    }
    public SignUpPage clickOnCountrySelection(){
        click(countryCodeSelect);
        return this;
    }

    public SignUpPage selectCountryCode(String countryCodeNum){
//        clear(countrySearch);
//        sendKeys(countrySearch,countryCodeNum);
//        WebElement countrySelectionTemp = (WebElement) driver.findElement(
//                By.xpath("//*[@id='textView_code' and @text='"+countryCodeNum+"']/.."));
//        click(countrySelectionTemp);
        return this;
    }

    public SignUpPage clickOnErrorPanelOK(){
        click(errorPanelOkBtn);
        return this;
    }

    public boolean isErrorPanelVisible(){
        return isElementDisplayed(errorPanel);
    }

    public String getErrorText(){
        return getText(errorPanelText);
    }


    public boolean isSignUpSuccess(){
        return isElementDisplayed(successSignUp);
    }

    public String getSuccessSignupMessage(){
        return getText(successSignUp);
    }

//    public String getErrorTextIfErrorDisplayed(){
//        if(isErrorPanelVisible()){
//            return getErrorText();
//        }return "";
//    }







}
