package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertTrue;

public class TestAppium {
    private static AppiumDriver<MobileElement> driver;

    @BeforeClass
    public static void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Nexus_5X_API_27");
        capabilities.setCapability("platformVersion", "5.2");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("avd", "Nexus_5X_API_27");

        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public static void end_test(){
        driver.quit();
        closeEmulator();
    }

    @Test
    public void test_positive1_float_addition(){

        MobileElement number5 = driver.findElementById("com.android.calculator2:id/digit_5");
        number5.click();

        MobileElement point = driver.findElementById("com.android.calculator2:id/dec_point");
        point.click();

        MobileElement number3 = driver.findElementById("com.android.calculator2:id/digit_3");
        number3.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_add");
        operation.click();

        number5.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("Неверный результат", result.getText().equals("10.3"));
    }

    @Test
    public void test_positive1_float_multiplication(){

        MobileElement number1 = driver.findElementById("com.android.calculator2:id/digit_1");
        number1.click();

        MobileElement point = driver.findElementById("com.android.calculator2:id/dec_point");
        point.click();

        MobileElement number2 = driver.findElementById("com.android.calculator2:id/digit_2");
        number2.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_mul");
        operation.click();

        MobileElement number0 = driver.findElementById("com.android.calculator2:id/digit_0");
        number0.click();

        point.click();

        MobileElement number7 = driver.findElementById("com.android.calculator2:id/digit_7");
        number7.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("Неверный результат", result.getText().equals("0.84"));
    }

    @Test
    public void test_positive1_float_division(){

        MobileElement number0 = driver.findElementById("com.android.calculator2:id/digit_0");
        number0.click();

        MobileElement point = driver.findElementById("com.android.calculator2:id/dec_point");
        point.click();

        MobileElement number1 = driver.findElementById("com.android.calculator2:id/digit_1");
        number1.click();

        MobileElement operation = driver.findElementById("com.android.calculator2:id/op_div");
        operation.click();

        number0.click();

        point.click();

        MobileElement number2 = driver.findElementById("com.android.calculator2:id/digit_2");
        number2.click();

        MobileElement eq = driver.findElementById("com.android.calculator2:id/eq");
        eq.click();

        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        assertTrue("Неверный результат", result.getText().equals("0.5"));
    }

    private static void closeEmulator(){
        System.out.println("Closing Emulator");

    }
}
