import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class desiredCapabilities {

    WebDriver driver;
    String baseUrl = "https://www.amazon.com/";
    String expectedTitle ="Amazon.com. Spend less. Smile more.";
    String actualTitle="";



    public void capabilities()  {
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeoption = new ChromeOptions();
       // chromeoption.addArguments("start-maximized");
       // chromeoption.addArguments("incognito");
        chromeoption.addArguments("headless");  // automation run without open window


        driver = new ChromeDriver(chromeoption);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        actualTitle= driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        desiredCapabilities mybrowser = new desiredCapabilities();
        mybrowser.capabilities();

    }
}
