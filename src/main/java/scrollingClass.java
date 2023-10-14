import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class scrollingClass {

    WebDriver driver;
    String baseURL ="http://demo.guru99.com/test/guru99home/";

    @BeforeTest
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }

    @Test
    public void script() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    @Test
    public void scrollDownByPixle() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1250)");
    }

    @Test
    public void scrollDownByElement() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement playstoreIcon = driver.findElement(By.xpath("//img[@src='images/app_google_play(1).png']"));
        js.executeScript("arguments[0].scrollIntoView();",playstoreIcon );
    }
}
