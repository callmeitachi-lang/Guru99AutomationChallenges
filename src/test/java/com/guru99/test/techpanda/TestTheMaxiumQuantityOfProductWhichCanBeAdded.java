package com.guru99.test.techpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestTheMaxiumQuantityOfProductWhichCanBeAdded {
    private WebDriver driver;
    SoftAssert softAssert;
    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" http://live.techpanda.org/index.php/");
         softAssert=new SoftAssert();
    }

    @Test
    public void checkTheMaximumOrder()
    {

        driver.findElement(By.cssSelector(".level0.nav-1 a")).click();
        driver.findElement(By.xpath("(//div[@class=\"actions\"]/button[@type='button']//span/span)[3]")).click();
        driver.findElement(By.cssSelector(".product-cart-actions input[type='text']")).sendKeys("000");
        driver.findElement(By.cssSelector("button[title='Update'] span span")).click();

        softAssert.assertEquals(driver.findElement(By.cssSelector(".item-msg.error")).getText().trim(),"* The maximum quantity allowed for purchase is 500.");
        driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span")).click();
        driver.findElement(By.cssSelector(".page-title h1")).getText();
        softAssert.assertEquals(driver.findElement(By.cssSelector(".page-title h1")).getText().trim(),"SHOPPING CART IS EMPTY");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown()
    {
      driver.quit();

    }


}
