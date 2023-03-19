package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("defaultUsername"));
        loginPage.passInput.sendKeys(ConfigurationReader.getProperty("defaultPassword"));
    }
    @When("clicks on logout")
    public void clicks_on_logout() {
        dashboardPage.userBlock.click();
        dashboardPage.logoutBtn.click();
    }

    @When("clicks on go back arrow in browser")
    public void clicks_on_go_back_arrow_in_browser() {
        Driver.getDriver().navigate().back();
    }

    @When("user closes the browser")
    public void user_closes_the_browser() {
        Driver.closeDriver();
    }
    @When("re opens the browser")
    public void re_opens_the_browser() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa.web.url"));
    }
    @Then("should be asked to re enter login credentials")
    public void should_be_asked_to_re_enter_login_credentials() {
        Assert.assertTrue(loginPage.verifiesUserIsOnLoginPage.isDisplayed());
    }
}
