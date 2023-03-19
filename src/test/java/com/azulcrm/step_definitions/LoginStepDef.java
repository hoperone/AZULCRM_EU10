package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.GetPasswordPage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    GetPasswordPage getPasswordPage = new GetPasswordPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("qa.web.url");
        Driver.getDriver().get(url);
    }

    @When("I enter valid HR username {string}")
    public void i_enter_valid_hr_username(String string) {
        loginPage.loginInput.sendKeys(string);
    }

    @When("I enter valid HR password {string}")
    public void i_enter_valid_hr_password(String string) {
        loginPage.passInput.sendKeys(string);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.loginBtn.click();
    }

    @Then("I should be redirected to the HR dashboard")
    public void i_should_be_redirected_to_the_hr_dashboard() {
        Assert.assertTrue("user block is not displayed", dashboardPage.userBlock.isDisplayed());
    }

    @When("I enter valid Marketing username {string}")
    public void i_enter_valid_marketing_username(String string) {
        loginPage.loginInput.sendKeys(string);

    }

    @When("I enter valid Marketing password {string}")
    public void i_enter_valid_marketing_password(String string) {
        loginPage.passInput.sendKeys(string);

    }

    @Then("I should be redirected to the Marketing dashboard")
    public void i_should_be_redirected_to_the_marketing_dashboard() {
        Assert.assertTrue("user block is not displayed", dashboardPage.userBlock.isDisplayed());

    }

    @When("I enter valid Helpdesk username {string}")
    public void i_enter_valid_helpdesk_username(String string) {
        loginPage.loginInput.sendKeys(string);

    }

    @When("I enter valid Helpdesk password {string}")
    public void i_enter_valid_helpdesk_password(String string) {
        loginPage.passInput.sendKeys(string);

    }

    @When("I enter invalid password {string}")
    public void i_enter_invalid_password(String string) {
        loginPage.passInput.sendKeys(string);
    }

    @Then("I should be redirected to the Helpdesk dashboard")
    public void i_should_be_redirected_to_the_helpdesk_dashboard() {
        Assert.assertTrue("user block is not displayed", dashboardPage.userBlock.isDisplayed());

    }

    @Then("I should see a {string} link")
    public void i_should_see_a_link(String string) {
        String actualText = loginPage.loginItemCheckboxLabel.getText();
        Assert.assertEquals(string, actualText);
    }
    @Then("the link should be clickable")
    public void the_link_should_be_clickable() {
        loginPage.loginItemCheckboxLabel.click();
        Assert.assertTrue(loginPage.userRememberCheckbox.isSelected());
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
       loginPage.forgetPassLink.click();
    }
    @Then("user lands on the {string} page")
    public void user_lands_on_the_page(String string) {
        String actualResult = getPasswordPage.getPasswordText.getText();
        Assert.assertEquals(string, actualResult);
    }

    @When("user enters a random password")
    public void user_enters_a_random_password() {
        loginPage.passInput.sendKeys("39jdf933333f");
    }


    @Then("user sees the password in bullet signs")
    public void user_sees_the_password_in_bullet_signs() {
         /*
    To assert that the user can't see the password in Selenium, you can verify that
    the password input element has its type attribute set to "password".
    This attribute is used to specify the type of input field,
    and "password" is the value used to indicate a password input field,
    which will mask the input with bullet signs or asterisks.
    If the type attribute is not set to "password",
    then the user may be able to see the password they are entering.
     */
        // Get the value of the type attribute
        String passType = loginPage.passInput.getAttribute("type");
        Assert.assertEquals("password", passType);
    }

    @When("I enter valid username {string}")
    public void i_enter_valid_username(String string) {
        loginPage.loginInput.sendKeys(string);
    }
    @When("I enter valid password {string}")
    public void i_enter_valid_password(String string) {
        loginPage.passInput.sendKeys(string);
    }

    @Then("users can see their own usernames {string} in the profile menu")
    public void users_can_see_their_own_usernames_in_the_profile_menu(String string) {
        String actualUserNameText = dashboardPage.userName.getText();

        Assert.assertEquals(string, actualUserNameText);
    }

    @When("hit enter key on keyboard")
    public void hit_enter_key_on_keyboard() {
        loginPage.passInput.sendKeys(Keys.ENTER);
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {
        String actualErrorTextText = loginPage.errorText.getText();

        Assert.assertEquals(string, actualErrorTextText);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        String actualErrorText = loginPage.errorText.getText();

        Assert.assertEquals(string, actualErrorText);
    }

}
