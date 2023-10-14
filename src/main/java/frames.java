import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class frames {
    WebDriver driver;
    String baseUrl = "http://demo.guru99.com/test/guru99home/";

@Test
    public void frameExample() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "D:\\SeleniumClassWorkspace\\SelenumDrivers\\chrome\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.get(baseUrl);
    driver.switchTo().frame("a077aa5e");
    driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


}
}
