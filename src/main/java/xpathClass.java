import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class xpathClass {

    WebDriver driver;
    String baseUrl = "https://www.amazon.com/";




    public void xpaths() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement xpathA = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        xpathA.sendKeys("Nokia");
        WebElement search = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        search.click();



    }

    public static void main(String[] args) throws InterruptedException {
        xpathClass mybrowser = new xpathClass();
        mybrowser.xpaths();

    }
}
