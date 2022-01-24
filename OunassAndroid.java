package TestProject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OunassAndroid {

    public static void main (String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        //caps.setCapability("deviceName", "TECNO CAMON 15");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TECNO CAMON 15");
        caps.setCapability("udid", "050172502J000780");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");

        caps.setCapability("appPackage", "com.altayer.ounassapplication");
        caps.setCapability("appActivity", "com.altayer.ounassapplication.SplashScreen");

        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

        AppiumDriver<MobileElement> driver;
        driver = new AppiumDriver<MobileElement>(url, caps);

        System.out.println("Application Started!");

        //Select Region
        MobileElement uaeButton = (MobileElement) driver.findElement(By.id("com.altayer.ounassapplication:id/uaeImageView"));
        uaeButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Select Language
        MobileElement englishButton = (MobileElement) driver.findElement(By.id("com.altayer.ounassapplication:id/buttonEnglish"));
        englishButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select Category
        MobileElement shopMen = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"SHOP MEN\"]"));
        shopMen.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the Product
        MobileElement Product = (MobileElement) driver.findElement(By.xpath("//android.view.View/android.widget.Image[2]"));
        Product.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select Size Dropdown
        MobileElement selectSize = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[6]/android.widget.Button[1]"));
        selectSize.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Choose Size
        MobileElement size = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[7]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.Button"));
        size.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click Add to Bag Button
        MobileElement addToBag = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[7]/android.view.View/android.widget.Button[3]"));
        addToBag.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Go to Cart from Bag icon
        MobileElement goToCart = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc='icon-bag']/android.widget.Image"));
        goToCart.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
