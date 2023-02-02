package com.guru99.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserFactory {

    protected WebDriver driver;
    Properties prop;

    public WebDriver init_driver() {
        // to be used for normal testng
        String browserName = prop.getProperty("browser");
         //for runtime
        //String browserName = System.getProperty("browser");

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        return driver;

    }



    public Properties init_prop() {
        FileInputStream io = null;
        try {
            io = new FileInputStream("C:\\Users\\knwrp\\IdeaProjects\\guru99SeleniumProject\\src\\main\\java\\com\\guru99\\Config\\stage.config.properties");
            prop = new Properties();
            prop.load(io);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }


}
