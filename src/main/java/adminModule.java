import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class adminModule {
        WebDriver driver;
        String baseURL = "https://qagovsl.southeastasia.cloudapp.azure.com/web/index.php/auth/login";
        String expectedTitle = "My Profile";
        String actualTitle = "";

        @BeforeTest ()
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        }

        @Test ()
        public void pageLogin() {

            driver.get(baseURL);
            driver.findElement(By.name("username")).sendKeys("lalith");
            driver.findElement(By.name("password")).sendKeys("Lalith@123");
            WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
            submit.click();

                actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle, expectedTitle);
        }

        @Test()
        public void pageTitle() {
        }

        @Test
        public void closeBrowser() {
            driver.close();

        }


}
