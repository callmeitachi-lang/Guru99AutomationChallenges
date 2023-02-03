package com.guru99.test;

import com.guru99.Utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNegativeLoginPageCred extends BaseTest{

    /*@DataProvider
    public Object[][] getData()
    {
        Object[][] data= ExcelUtils.getTestData("Login");
        return data;
    }
    */

    /**
     * this method is for dynamic testing where we wont use excel
     * @return 2d arrays of data
     */
    @DataProvider
    public Object[][] getDataBy()
    {
        return new Object[][]{{"mngr472001","xxxxxx"},{"xxxxxx","adeteqA"},{"xxxxxxinvalid","xxxxxxinvalid"}};
    }


   @Test(dataProvider = "getDataBy",enabled = false)
   public void validateLoginWithNegCred(String username,String password) throws InterruptedException {
       loginPage.dologinWithNegativeCred(username,password);
   }

}
