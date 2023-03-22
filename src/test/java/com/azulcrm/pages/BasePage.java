package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
