

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class myTests implements Runnable{
    private static final String USERNAME = "eyalk";
    private static final String PASSWORD = "Experitest2012";
    private static final String PROJECT = "Default";
    //private static final String ACCESSKEY = "eyJ4cC51Ijo4NSwieHAucCI6MiwieHAubSI6Ik1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4Mjg5NDU4MjksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NJ0DFLOdtLvkhz6NPPNtRu2GZFLwhCprzeohEyd3FZY";
   // String CLOUDURL = "https://sales.experitest.com/wd/hub/";
    String CLOUDURL = "https://qacloud.experitest.com/wd/hub";
   // String CLOUDURL = "192.168.2.135/wd/hub";
    PlatformType platform;
    String testName;
    WebDriver driver;

    public myTests(PlatformType _platform, String _testName){
        this.platform= _platform;
        this.testName= _testName;
    }

    @Override
    public void run(){
        try {
            getDriver(platform, testName, true);

            driver.get("https://www.google.com");
            Thread.sleep(8000);
            WebElement searchBar = driver.findElement(By.id("lst-ib"));
            searchBar.click();
            Thread.sleep(5000);
            searchBar.sendKeys("Jerusalem");

           /* driver.findElement(By.xpath("//*[@id=\"hplogo\"]/div")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[contains(text(), 'History of Jerusalem')]")).click();
           */ Thread.sleep(5000);
            System.out.println("url of page is: " + driver.getCurrentUrl());
            System.out.println("title of page is: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    public void getDriver(PlatformType platform, String testName, boolean generateReport) throws MalformedURLException {
        //Set Browser Type
        DesiredCapabilities dc = new DesiredCapabilities();

        if (platform == PlatformType.CHROME) {
            dc = DesiredCapabilities.chrome();
        } else if (platform == PlatformType.FIREFOX) {
            dc = DesiredCapabilities.firefox();
        } else if (platform == PlatformType.IE) {
            dc = DesiredCapabilities.internetExplorer();
        } else if (platform == PlatformType.ANDROID) {
            dc = DesiredCapabilities.chrome();
            dc.setCapability("platformName", "Android");
        } else if (platform == PlatformType.IOS) {
            dc = DesiredCapabilities.iphone();
            dc.setCapability("platformName", "ios");
        }
        //Set Grid capabilities
        dc.setCapability("user", USERNAME);
        dc.setCapability("password", PASSWORD);
        dc.setCapability("project", PROJECT);
      //  dc.setCapability("accessKey", ACCESSKEY);
        
        dc.setCapability("generateReport", generateReport);
        dc.setCapability("testName", testName);

        this.driver = new RemoteWebDriver(new URL(CLOUDURL), dc);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void getTitle_test() throws Exception {
        driver.get("https://experitest.com/");
        Thread.sleep(10000);
        System.out.println("title of page is: " + driver.getTitle());
    }
}