package com.amazon.pages;

import com.pnt.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends TestBase {

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccountButton;

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }
}
