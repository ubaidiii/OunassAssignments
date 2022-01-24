package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OunassWebTask {
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

        //SelectCategory
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[1]/a[2]/div/span")).click();

        //SelectProduct
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div/div[10]/div[2]/div/div[1]/div[1]/div/a/img[2]")).click();

        //SelectSize
        driver.findElement(By.cssSelector("div.Select-placeholder")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-select-2--option-2\"]"))).click();

        //AddToBag
        driver.findElement(By.cssSelector("button.AddToBag")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //SelectPDP2
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/a/img[2]")).click();

        //SelectSize
        driver.findElement(By.cssSelector("div.Select-placeholder")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-select-2--option-1\"]"))).click();

        //AddTOBag2
        driver.findElement(By.cssSelector("button.AddToBag")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Hover on Bag
        WebElement bag = driver.findElement(By.cssSelector("a.Popup-iconLink.has-product"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bag);
        WebElement goToBagButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[4]/div/div/div/div[3]/div/a")));
        System.out.println("Since "+goToBagButton.getText()+" button is visible, hence the Products are added to Bag.");


        //GotoBag
        driver.findElement(By.cssSelector("a.Popup-iconLink.has-product")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //CheckOut
        driver.findElement(By.cssSelector("button.CartTotal-secureCheckout")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //ShippingInfo
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");
        driver.findElement(By.id("mobileNumber")).sendKeys("501234567");
        driver.findElement(By.cssSelector("div.Select-placeholder")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-select-3--option-0\"]"))).click();
        driver.findElement(By.name("city")).sendKeys("XYZ Area");
        driver.findElement(By.id("street")).sendKeys("ABC Building");
        driver.findElement(By.id("additionalInformation")).sendKeys("Appartment 2");
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[3]/div/form/section[3]/div/div[2]/label/div")).click();

        //ContinueShipping
        driver.findElement(By.cssSelector("button.ShippingInformationForm-submitButton")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Payment Page URL: "+driver.getCurrentUrl());
        System.out.println("Task has been completed!");

        //driver.close();
    }
}
