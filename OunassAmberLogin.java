package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OunassAmberLogin {
    public static void main (String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //LandingPage
        driver.get("https://www.ounass.ae/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //CancelPushNotification
        driver.findElement(By.id("wzrk-cancel")).click();

        //ClickAccount
        driver.findElement(By.cssSelector("div.Popup-iconText")).click();

        //ContinueWithAmber
        driver.findElement(By.cssSelector("button.SignInThirdpartyButtons-amberButton")).click();

        //GoToNewWindow
        String parentWindowHandler = driver.getWindowHandle(); // parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

        //LoginWithFacebook
        driver.findElement(By.id("btnCreateAccountWithFacebook")).click();

        //GoToNewWindow
        String parentWindowHandler2 = driver.getWindowHandle(); // Store parent window
        String subWindowHandler2 = null;

        Set<String> handles2 = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator2 = handles2.iterator();
        while (iterator2.hasNext()){
            subWindowHandler2 = iterator2.next();
        }
        driver.switchTo().window(subWindowHandler2);


        //GetErrorMessage
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]"));
        System.out.println(errorMessage.getText());

        //ClosingWindows
        driver.close();

        // SwitchingtoParentWindow
        driver.switchTo().window(parentWindowHandler2);

        // ClosingParentWindow
        //driver.close();
    }
}
