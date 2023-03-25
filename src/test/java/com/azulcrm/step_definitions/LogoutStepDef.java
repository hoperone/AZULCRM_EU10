package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogoutStepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @When("clicks on go back arrow in browser")
    public void clicks_on_go_back_arrow_in_browser() {
        Driver.getDriver().navigate().back();
    }

    //EDITED
    @When("The user clicks on logout button")
    public void the_user_clicks_on_logout_button() {
        dashboardPage.userBlock.click();
        dashboardPage.logoutBtn.click();
    }

    @Then("The user ends up on the {string} page")
    public void the_user_ends_up_on_the_page(String expectedPageTitle) {
        String actualPageTitle = loginPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @When("The user closes all the open tabs")
    public void the_user_closes_all_the_open_tabs() {
        // here we open an empty tab in advance,
        // otherwise after closing open tabs,
        // we'll get NoSessionException
        BrowserUtils.openNewTab();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allOpenTabs = new ArrayList<>(windowHandles);

        //allOpenTabs.size()-1 --> don't close the empty tab
        for (int i = 0; i < allOpenTabs.size() - 1; i++) {
            Driver.getDriver().switchTo().window(allOpenTabs.get(i));
            Driver.getDriver().close();
        }
        BrowserUtils.switchToWindow(0);
    }
}
