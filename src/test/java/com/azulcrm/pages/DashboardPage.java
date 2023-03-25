package com.azulcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(id = "user-block")
    public WebElement userBlock;

    @FindBy(xpath = "//span[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logoutBtn;


}
