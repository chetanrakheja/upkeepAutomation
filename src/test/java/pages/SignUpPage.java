package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class SignUpPage extends BaseTest {

    @AndroidFindBy(id="edit_text_email")
    private WebElement emailTextField;

    @AndroidFindBy(id="edit_text_password")
    private  WebElement passwordField;

    @AndroidFindBy(id="edit_text_first_name")
    private WebElement fName;

    @AndroidFindBy(id="edit_text_last_name")
    private WebElement lName;

    @AndroidFindBy(id="rlClickConsumer")
    private WebElement countryCodeSelect;

    @AndroidFindBy(id="editText_search")
    private WebElement countrySearch;

    @AndroidFindBy(id="edit_text_phone_number")
    private WebElement mobileNumField;

    @AndroidFindBy(id="edit_text_company_name")
    private WebElement companyName;

    @AndroidFindBy(id="edit_text_job_title")
    private WebElement jobTitle;

    @AndroidFindBy(id="button_signup")
    private WebElement getStartedBtn;

    @AndroidFindBy(id="parentPanel")
    private WebElement errorPanel;

    @AndroidFindBy(id="button1")
    private WebElement errorPanelOkBtn;

    @AndroidFindBy(id="message")
    private WebElement errorPanelText;

    @AndroidFindBy(id="tv_title")
    private WebElement successSignUp;

    @AndroidFindBy(id="button_sign_up")
    private WebElement signUpBtn;

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
        click(passwordField);
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
