import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ajaxHandlingClass {

    WebDriver driver;
    String baseURL ="http://demo.guru99.com/test/ajax.html";
    String expectedTitle ="Radio button is checked and it's value is Yes";
    String actualTitle ="";


    @BeforeTest
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }

    @Test
    public void ajaxHandling(){
        driver.get(baseURL);
        WebElement notextElement = driver.findElement(By.className("radiobutton"));
        String textBefore =notextElement.getText().trim();
        driver.findElement(By.xpath("//input[@id='yes']")).click();
        driver.findElement(By.id("buttoncheck")).click();
        WebElement actualTitle  = driver.findElement(By.className("radiobutton"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(actualTitle));
        String afterText = actualTitle.getText().trim();
        Assert.assertNotEquals(textBefore,afterText);
    }
}
