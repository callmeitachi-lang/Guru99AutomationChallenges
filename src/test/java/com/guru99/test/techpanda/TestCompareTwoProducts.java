package com.guru99.test.techpanda;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestCompareTwoProducts {

   private WebDriver driver;
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
    public void compareTwoProductsTest()
    {
        driver.findElement(By.cssSelector(".level0.nav-1 a")).click();
        driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[1]")).click();
        driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[3]")).click();
        driver.findElement(By.cssSelector("button[title='Compare'] span span")).click();
        Set<String> newWindow=driver.getWindowHandles();
        List<String> totalWindows=new ArrayList<>(newWindow);
        driver.switchTo().window(totalWindows.get(1));
       // System.out.println(driver.getTitle());
         String fet=driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText();
        System.out.println(fet);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText(),"COMPARE PRODUCTS");
        driver.findElement(By.xpath("//span[contains(text(),'Close Window')]")).click();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
