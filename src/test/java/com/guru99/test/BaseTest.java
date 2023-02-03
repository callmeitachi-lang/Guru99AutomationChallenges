package com.guru99.test;


import com.guru99.base.BrowserFactory;
import com.guru99.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;



import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BrowserFactory browserFactory;
    Properties prop;
  // @BeforeMethod
   public void setup()
   {
       browserFactory = new BrowserFactory();
       prop=browserFactory.init_prop();
       driver=browserFactory.init_driver();
        loginPage = new LoginPage(driver);

   }

   //@AfterMethod
    public void tearDown(ITestResult iTestResult)

   {
       {
           if (iTestResult.getStatus()==ITestResult.FAILURE)
           {
               File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
               String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
               File destination = new File(path);
               try {
                   FileUtils.copyFile(scrFile,destination);
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

           }

       }
       driver.quit();
   }

}
