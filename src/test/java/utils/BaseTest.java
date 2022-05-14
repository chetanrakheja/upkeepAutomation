package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AppiumDriver driver;
    protected Properties props;
    public Properties ErrorProp;
    InputStream inputStream,inputStream2;


    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void loadAllProperties() throws IOException {
        props = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        props.load(inputStream);

        ErrorProp = new Properties();
        String errorProperties = "ErrorMsgs.properties";
        inputStream2 = getClass().getClassLoader().getResourceAsStream(errorProperties);
        ErrorProp.load(inputStream2);
    }

    @BeforeTest
    public void beforeTest() {
        try {
            loadAllProperties();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("deviceName", props.getProperty("android.deviceName"));
            desiredCapabilities.setCapability("AutomationName", "UiAutomator2");
            desiredCapabilities.setCapability("appPackage", props.getProperty("android.appPackage"));
            desiredCapabilities.setCapability("appActivity", props.getProperty("android.appActivity"));
            desiredCapabilities.setCapability("udid", props.getProperty("android.udid"));
            //Trying To reduce Working Time
            desiredCapabilities.setCapability("ignoreUnimportantViews", true);
            desiredCapabilities.setCapability("disableAndroidWatchers", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver(url, desiredCapabilities);
            String sessionID = driver.getSessionId().toString();
            System.out.println("Session ID" +sessionID);
//            driver.manage().timeouts().implicitlyWait(TestUtils.Wait1);
//            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitForVisibility(WebElement e){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void clear(WebElement e) {
//        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
//        waitForVisibility(e);
        System.out.println("Clicking on Element");
        e.click();
        System.out.println("Clicked on Element");
        System.out.println("");
    }

//    public void click(WebElement e, String msg) {
//        waitForVisibility(e);
//        utils.log().info(msg);
//        ExtentReport.getTest().log(Status.INFO, msg);
//        e.click();
//    }

    public void sendKeys(WebElement e, String txt) {
//        waitForVisibility(e);
//        click(e);
        System.out.println("Send Keys as "+txt);
        e.sendKeys(txt);
        System.out.println("Keys sent");
        System.out.println("");

    }

//    public void sendKeys(WebElement e, String txt, String msg) {
//        waitForVisibility(e);
//        utils.log().info(msg);
//        ExtentReport.getTest().log(Status.INFO, msg);
//        e.sendKeys(txt);
//    }

    public String getAttribute(WebElement e, String attribute) {
//        waitForVisibility(e);
        System.out.println("Getting Attribute");
        return e.getAttribute(attribute);
    }


    public String getText(WebElement e) {
        String txt = null;
        txt = getAttribute(e, "text");
        System.out.println("Got text as "+txt);
        return txt;
    }

    public Boolean isElementDisplayed(WebElement e) {
        System.out.println("Checking if element is displayed");
        return e.isDisplayed();
    }

//    public String getText(WebElement e, String msg) {
//        String txt = null;
//        txt = getAttribute(e, "text");
//        utils.log().info(msg + txt);
//        ExtentReport.getTest().log(Status.INFO, msg + txt);
//        return txt;
//    }

//    @AfterTest
    public void afterTest(){
        driver.quit();
    }






}

