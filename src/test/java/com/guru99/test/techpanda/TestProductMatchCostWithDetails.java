package com.guru99.test.techpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestProductMatchCostWithDetails {

    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" http://live.techpanda.org/index.php/");
    }
    @Test
    public void matchProductPriceWithProDetailPrice()
    {
        driver.findElement(By.cssSelector(".level0.nav-1 a")).click();

        String productPrice=driver.findElement(By.cssSelector("span[id='product-price-1'] span[class='price']")).getText();

   driver.findElement(By.cssSelector("a[title='Sony Xperia']")).click();
        String productPriceOnDetail=driver.findElement(By.xpath("//span[@class='price']")).getText();
        Assert.assertEquals(productPrice,productPriceOnDetail);

    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }



}
