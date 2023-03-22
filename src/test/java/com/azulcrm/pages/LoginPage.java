package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "USER_LOGIN")
    public WebElement loginInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passInput;

    @FindBy(className = "login-btn")
    public WebElement loginBtn;

    @FindBy(className = "login-item-checkbox-label")
    public WebElement loginItemCheckboxLabel;

    @FindBy(id = "USER_REMEMBER")
    public WebElement userRememberCheckbox;

    @FindBy(className = "login-link-forgot-pass")
    public WebElement forgetPassLink;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errorText;

    @FindBy(xpath = "//div[.='Authorization']")
    public WebElement verifiesUserIsOnLoginPage;
}


