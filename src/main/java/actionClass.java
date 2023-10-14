import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class actionClass {
    WebDriver driver;
    String baseUrl = "http://www.facebook.com/";

    public void setEmail() {
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        Actions builder = new Actions(driver);
        WebElement textfield = driver.findElement(By.id("email"));
        Action Email = builder.moveToElement(textfield)
                .click()
                .keyDown(textfield, Keys.SHIFT)
                .sendKeys(textfield,"hirukshijayapathma92@gmail.com")
                .keyUp(textfield,Keys.SHIFT)
                .doubleClick(textfield)
                .build();
        Email.perform();

    }

    public static void main(String[] args)  {
        actionClass mybrowser = new actionClass();
        mybrowser.setEmail();

    }
}


