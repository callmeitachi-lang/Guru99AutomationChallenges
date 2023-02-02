package com.guru99.test.techpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class TestSortTheProductsByName {

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

  @Test(priority = 1)
  public void homePageTitleTest()
  {
      Assert.assertEquals(driver.getTitle(),"Home page");

  }

    @Test(priority = 2)
    public void sortByNameTest()
    {

        driver.findElement(By.cssSelector(".level0.nav-1 a")).click();
        List<WebElement> mobileProducts= driver.findElements(By.cssSelector("h2.product-name a"));
        List<String> getMobileNames=new ArrayList<>();
        for (WebElement e:mobileProducts)
        {
           // System.out.println(e.getText());
            getMobileNames.add(e.getText());

        }

        Collections.sort(getMobileNames);

       WebElement element= driver.findElement(By.cssSelector("div[class='toolbar-bottom'] select[title='Sort By']"));

        Select select=new Select(element);

        List<WebElement>  options=select.getOptions();
      for(WebElement k:options)
      {
          if (k.getText().trim().equals("Name"))
          {
              k.click();
              break;
          }
      }
        List<String> getMobileNames1=new ArrayList<>();
        List<WebElement> mobileProductsAfterSorting= driver.findElements(By.cssSelector("h2.product-name a"));
        for (WebElement e:mobileProductsAfterSorting)
        {
            System.out.println(e.getText());
            getMobileNames1.add(e.getText());
        }

          Assert.assertEquals(getMobileNames1,getMobileNames1);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
