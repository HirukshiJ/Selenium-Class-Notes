import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class priorityLevelDefineClass {

        WebDriver driver;
        String baseURL = "https://www.amazon.com/";
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = "";

        @Test(priority = 0)
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        }

        @Test(priority = 1)
        public void pageTitle() {

            driver.get(baseURL);
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);

        }

        @Test(priority = 2)
        public void closeBrowser() {
            driver.close();

        }

    }


