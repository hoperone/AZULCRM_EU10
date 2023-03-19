package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-block")
    public WebElement userBlock;

    @FindBy(xpath = "//span[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logoutBtn;


}
