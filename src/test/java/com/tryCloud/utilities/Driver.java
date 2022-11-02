package com.tryCloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //creating a private constrictor, so we are closing access to the object of this class from outside the class
    private Driver() {
    }

    //private access closes access from outside the class
    //we make it static because we will use it in a static method
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //create a reusable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            //we read our browser type from configuration.properties, this way we can control which browser  is opened from outside our code, from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");

            //Depending on the browser type that will be returned from configuration.properties file, switch statement will determine the case, and open the matching browser
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
            }

        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

