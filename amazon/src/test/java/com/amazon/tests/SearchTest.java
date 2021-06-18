package com.amazon.tests;

import com.amazon.data.DataProvidersForTests;
import com.amazon.pages.HomePage;
import com.pnt.base.ConnectDB;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchTest extends TestBase {

    private HomePage homePage;
    @BeforeMethod
    public void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }


    private static Logger LOGGER = Logger.getLogger(SearchTest.class);

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItem1(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nike");
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);
        driver.findElement(By.id("nav-search-submit-button")).click();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItemUsingPageObjectModel1(){


        homePage.typeOnSearchBar1();
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);
        homePage.clickOnSearchButton1();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItemUsingPageObjectModel2(){

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        homePage.typeOnSearchBar2("Nike");
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);

        homePage.clickOnSearchButton2();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }

    @Test(enabled = false,dataProviderClass = DataProvidersForTests.class, dataProvider = "getDataForSearchtest",groups = "regression")
    public void validateUserBeingAbleToSearchForAnItemUsingPageObjectModel3(String bookName){

        validateUrlWithExpected("https://www.amazon.com");

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        homePage.typeOnSearchBar2(bookName);
        ExtentTestManager.log(bookName+ "typed on the search bar.",LOGGER);

        homePage.clickOnSearchButton2();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }


    @Test(enabled = true)
    public void validateUserBeingAbleToSearchForAnItemFromDatabase() throws SQLException {

        String query = "select * from testdata";

        ArrayList<String> datas = ConnectDB.connectToDbAndGetTheData(query,"brandName");
        
        homePage.typeOnSearchBar2(datas.get(0));
        ExtentTestManager.log(datas.get(0) + " typed on the search bar.",LOGGER);
        homePage.clickOnSearchButton1();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }
}
