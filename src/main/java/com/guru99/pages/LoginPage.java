package com.guru99.pages;


import com.guru99.base.BrowserFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BrowserFactory {

    By userId = By.name("uid");
    By password = By.name("password");
    By loginButton =By.name("btnLogin");
    By headerInHomePage = By.xpath("//h2[normalize-space()='Guru99 Bank']");

     public LoginPage(WebDriver driver)
     {

         this.driver =driver;
     }

     public String dologin(String username,String password)
     {  driver.findElement(userId).sendKeys(username);
         driver.findElement(this.password).sendKeys(password);
         driver.findElement(loginButton).click();
         return driver.findElement(headerInHomePage).getText();

     }

    public void dologinWithNegativeCred(String username,String password)
    {
       // longWait.until(ExpectedConditions.visibilityOfElementLocated(userId)).sendKeys(username);
        // longWait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
        // longWait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        driver.findElement(userId).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginButton).click();
        Alert alert=driver.switchTo().alert();
        //longWait.until(ExpectedConditions.alertIsPresent()).accept();
        /*alert.getText();*/
          alert.accept();

    }






}
