
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class alertClass {

        WebDriver driver;
        String baseUrl = "http://demo.guru99.com/test/delete_customer.php";


        public void alerts() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get(baseUrl);
            WebElement name = driver.findElement(By.name("cusid"));
            name.sendKeys("001");
            Thread.sleep(8000);
            WebElement submit = driver.findElement(By.name("submit"));
            Thread.sleep(8000);
            submit.click();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.accept();


        }

        public static void main(String[] args) throws InterruptedException {
            alertClass mybrowser = new alertClass();
            mybrowser.alerts();

        }
    }


