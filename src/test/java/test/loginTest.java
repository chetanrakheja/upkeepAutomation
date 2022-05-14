package test;

import feature.LoginFeature;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.InputStream;
import java.lang.reflect.Method;

public class loginTest extends BaseTest {
    JSONObject usersJSON;
    LoginFeature loginFeature;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream dataIS = null;
        try {
            String dataFileName = "loginUsers.json";
            dataIS = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(dataIS);
            usersJSON = new JSONObject(tokener);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(dataIS != null) {
                dataIS.close();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        loginFeature = new LoginFeature();
    }

    @Test
    public void successLoginHardCoded(){
//        LoginFeature loginFeature=new LoginFeature();
        loginFeature.login("rakhejachetan.dev@gmail.com","Chetan@1234");
    }

    @Test
    public void successLoginJson(){
//        LoginFeature loginFeature=new LoginFeature();
        loginFeature.login(usersJSON.getJSONObject("validUser").getString("username"),
                usersJSON.getJSONObject("validUser").getString("password"));

    }

    @Test
    public void failLoginJson(){
//        LoginFeature loginFeature=new LoginFeature();
        loginFeature.login(usersJSON.getJSONObject("invalidUser").getString("username"),
                usersJSON.getJSONObject("invalidUser").getString("password"))
                ;

    }


}
