package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetPasswordPage extends BasePage {

    @FindBy(className = "log-popup-header")
    public WebElement getPasswordText;
}
