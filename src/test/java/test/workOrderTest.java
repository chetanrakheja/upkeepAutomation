package test;

import Enums.WorkOrderPriority;
import feature.LoginFeature;
import feature.WorkOrderFeature;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;

import java.io.InputStream;
import java.lang.reflect.Method;

public class workOrderTest extends BaseTest {
    WorkOrderFeature workOrderFeature;
    HomePage homePage;
    JSONObject usersJSON;

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        workOrderFeature = new WorkOrderFeature();
        homePage = new HomePage();
    }

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

//Combined Cases for Demo Video Purpose
    @Test
    public void Login_CreateWorkOrder_LogoutTest(){
        homePage.gotoHomePageAfterLogin(
                usersJSON.getJSONObject("validUser").getString("username"),
                usersJSON.getJSONObject("validUser").getString("password"))
                .clickOnAddBtn();

        workOrderFeature
                .createWorkOrder("Test Work Order",
                "This Work order is just for Testing Purpose", WorkOrderPriority.MEDIUM);

        homePage
                .clickOnSettingsBtn()
                .clickOnLogOut()
                .clickOnLogOutOK();

    }


}
