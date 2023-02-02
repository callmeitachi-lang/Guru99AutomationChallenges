package com.guru99.test;


import com.guru99.Utils.ConstantsUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {


    @Test
    public void testLoginWithValidCred()
    {
        /* things to remember ---the access code is only for 20 days.....*/

        Assert.assertEquals(loginPage.dologin(prop.getProperty("username"),prop.getProperty("password")),
                   ConstantsUtil.HomePagevalue,"Name matches....!");

    }


}
