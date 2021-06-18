package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProvidersForTests {

    @DataProvider(name = "getDataForSearchtest")
    public Object[][] getDataForSearchtest(){
        return new Object[][]{{"Nike"},{"Adidas"}};
    }

    @DataProvider(name = "getDataForLoginTest")
    public Object[][] getDataForLoginTest(){
        return new Object[][]{
                {"testuser01","testuser01@gmail.com","testpass01"},
                {"testuser02","testuser02@gmail.com","testpass02"}
        };
    }

}
