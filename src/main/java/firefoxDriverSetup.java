import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class firefoxDriverSetup {
     //
    //initiate the browser
    WebDriver driver;
    //define string variable
    //define browser URL
    String baseURL = "https://www.amazon.com/";

    //Define string variable for assertion
    String expectedTitle ="Amazon.com. Spend less. Smile more.";
    String actualTitle ="";

    //string variable : Define next navigate URL
    String navigateURL = "https://www.youtube.com/";

    //define string variable to get the current URL
    String currURL ="";

    //define string variable to get the page source
    String pageSource ="";



    // define method "openBrowser()"
    public void openBrowser() throws InterruptedException {
        //initiate browser driver
        // using setProperty define (driver name , driver path/folder location)
        //System.setProperty("webdriver.gecko.driver", "D:\\SeleniumClassWorkspace\\SelenumDrivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        //initiate driver to define FirefoxDriver
        //driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver","D:\\SeleniumClassWorkspace\\SelenumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //deleteAllCookies() means delete all cookies and open pure browser
        driver.manage().deleteAllCookies();
        //maximize() means maximize the window size.
        driver.manage().window().maximize();
        //when executing the line by line;  wait 30 seconds after one line execute and then navigate to the next line.
        //implicitlyWait - Selenium WebDriver to wait for a certain measure of time before throwing an exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //pageLoadTimeout - the time to wait for a page to load completely before throwing an error.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseURL); //get url
        //get actual title of the page and assign to the "actualTitle".
        actualTitle = driver.getTitle();
        //if condition = check condition first
        //If actualTitle = expectedTitle, then should print "Test pass"
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test pass");
            //else should print "Test Fail"
        } else {
            System.out.println("Test Fail");
        }


        //define next navigate URL (Ex:Navigate to the youtube web page)
        driver.navigate().to(navigateURL);
        //wait 8000 mili-seconds
        Thread.sleep(8000);
        //current page refresh
        driver.navigate().refresh();
        //Again navigate to the previous link (Ex:Navigate to the Amazon web page)
        driver.navigate().back();
        Thread.sleep(8000);
        //Navigate to the next webpage (Ex:Navigate to the youtube web page)
        driver.navigate().forward();
        Thread.sleep(8000);
        //close current opened web browser.

        //get current URL
        currURL = driver.getCurrentUrl();
        System.out.println("the current URL is " + currURL);

        //get page source
        pageSource = driver.getPageSource();
        System.out.println("The page Source is "+pageSource);

        driver.close();


    }
    //define main method
    public static void main(String[] args) throws InterruptedException {
        //classname object name = new give a name
        //firefoxDriverSetup mybrowser = new firefoxDriverSetup();
        //object name.methodName();
        //mybrowser.openBrowser();

        firefoxDriverSetup mybrowser = new firefoxDriverSetup();
        mybrowser.openBrowser();

    }
}
