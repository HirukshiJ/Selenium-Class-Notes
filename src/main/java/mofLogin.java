import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class mofLogin {
WebDriver driver;
String baseURL = "https://qagovsl.southeastasia.cloudapp.azure.com/web/index.php/auth/login";

public void openBrowser () {
    System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    driver.get(baseURL);
    Actions builder = new Actions(driver);
    WebElement textfield = driver.findElement(By.name("username"));
    Action name = builder.moveToElement(textfield)
            .click()
            .keyDown(textfield, Keys.SHIFT)
            .sendKeys(textfield,"lalith")
            .keyUp(textfield,Keys.SHIFT)
            .doubleClick(textfield)
            .build();
    name.perform();

    WebElement pwdtextfield = driver.findElement(By.name("password"));
    Action pname = builder.moveToElement(pwdtextfield)
            .click()
            .keyDown(pwdtextfield,Keys.SHIFT)
            .sendKeys(pwdtextfield,"Lalith@123")
            .keyUp(pwdtextfield,Keys.SHIFT)
            .doubleClick(pwdtextfield)
            .build();
    pname.perform();

    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));


    submit.click();



}

public static void main (String[] args){
    mofLogin myBrowser = new mofLogin();
    myBrowser.openBrowser();
}
}
