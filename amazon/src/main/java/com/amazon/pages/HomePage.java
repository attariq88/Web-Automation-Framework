package com.amazon.pages;

import com.pnt.base.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    public void typeOnSearchBar1(){
        searchTextBox.sendKeys("Nike");
    }

    public void clickOnSearchButton1(){
        searchButton.click();
    }

    public void typeOnSearchBar2(String text){
        searchTextBox.sendKeys(text);
    }

    public void clickOnSearchButton2(){
        searchButton.click();
    }

    public void clickOnSignButton(){
        signInButton.click();
    }

}
