package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetPasswordPage {

    public GetPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "log-popup-header")
    public WebElement getPasswordText;
}
