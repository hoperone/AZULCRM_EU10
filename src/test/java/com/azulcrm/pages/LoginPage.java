package com.azulcrm.pages;

import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //--Locators--
    @FindBy(name = "USER_LOGIN")
    public WebElement loginInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passInput;

    @FindBy(className = "login-btn")
    public WebElement loginBtn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//label[.='Remember me on this computer']")
    public WebElement rememberMeLabel;

    @FindBy(className = "login-link-forgot-pass")
    public WebElement forgetPassLink;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errorText;

    @FindBy(xpath = "//div[.='Authorization']")
    public WebElement verifiesUserIsOnLoginPage;


    //--Methods--
    public void goLoginPage() {
        String url = ConfigurationReader.getProperty("qa.web.url");
        Driver.getDriver().get(url);
    }

    public void loginAsUserType(String userType) {
        String username = "";
        String password = "";

        if (userType.equalsIgnoreCase("HR")) {
            username = ConfigurationReader.getProperty("hrUserName");
            password = ConfigurationReader.getProperty("hrPassword");

        } else if (userType.equalsIgnoreCase("Marketing")) {
            username = ConfigurationReader.getProperty("marketingUserName");
            password = ConfigurationReader.getProperty("marketingPassword");

        } else if (userType.equalsIgnoreCase("Helpdesk")) {
            username = ConfigurationReader.getProperty("helpdeskUserName");
            password = ConfigurationReader.getProperty("helpdeskPassword");
        }

        loginInput.sendKeys(username);
        passInput.sendKeys(password);
        loginBtn.click();
    }

    public void userEntersWrongPassword(){
        String password = "wrongpassword";
        passInput.sendKeys(password);
    }

    public void invalidUsername(){
        String username = "invalidusername";
        loginInput.sendKeys(username);
    }
    public void userEntersValidUsername(){
        loginInput.sendKeys(ConfigurationReader.getProperty("hrUserName"));
    }
    public void userEntersValidPassword(){
        passInput.sendKeys(ConfigurationReader.getProperty("hrPassword"));
    }

    public void userEntersInvalidPassword(){
        passInput.sendKeys("wrongpassword");
    }

}


