import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class driverSetup {

 WebDriver driver;
 String baseURL = "https://www.amazon.com/";
 String expectedTitle ="Amazon.com. Spend less. Smile more.";
 String actualTitle="";

 String navigateURL = "https://www.youtube.com/";


    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseURL);
        actualTitle= driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
        driver.navigate().to(navigateURL);
        Thread.sleep(8000);
        driver.navigate().refresh();
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {

        driverSetup mybrowser = new driverSetup();
        mybrowser.openBrowser();

    }
}
