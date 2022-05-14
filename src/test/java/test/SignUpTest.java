package test;

import feature.SignUpFeature;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class SignUpTest extends BaseTest {


    @Test
    public void emptyFields(){
        SignUpFeature signUpFeature=new SignUpFeature();
        String response = signUpFeature.signUp("","","","","","","","");
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingEmail")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingFName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingLName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingPNum")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingCompName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingTitle")));
    }

    @Test
    public void emptyFieldsAndIncorrectEmail(){
        SignUpFeature signUpFeature=new SignUpFeature();
        String response = signUpFeature.signUp("test","","","","","","","");
        Assert.assertTrue(response.contains(ErrorProp.getProperty("invalidEmail")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingFName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingLName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingPNum")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingCompName")));
        Assert.assertTrue(response.contains(ErrorProp.getProperty("missingTitle")));
    }

    @Test
    public void weekPassword(){
        SignUpFeature signUpFeature=new SignUpFeature();
        String response = signUpFeature.signUp("test@gmail.com","weekpass","FName","LName","","1234121","Company","job");
        Assert.assertTrue(response.contains(ErrorProp.getProperty("invalidPass")));
    }

    @Test
    public void SuccessSignup(){
        SignUpFeature signUpFeature=new SignUpFeature();
        String response = signUpFeature.signUp("test@gmail.com",
                "TestPass@12345",
                "FName",
                "LName",
                "",
                "123412121",
                "Company",
                "job");
        Assert.assertTrue(response.contains(ErrorProp.getProperty("SuccessSignup")));
    }


}
