package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.GetPasswordPage;
import com.azulcrm.pages.LoginPage;
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
        loginPage.goLoginPage();
    }

    @When("I enter invalid password {string}")
    public void i_enter_invalid_password(String string) {
        loginPage.passInput.sendKeys(string);
    }

    @Then("I should be redirected to the Helpdesk dashboard")
    public void i_should_be_redirected_to_the_helpdesk_dashboard() {
        Assert.assertTrue("user block is not displayed", dashboardPage.userBlock.isDisplayed());
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
    public void users_can_see_their_own_usernames_in_the_profile_menu(String usernameInProfileMenu) {
        String actualUserNameText = dashboardPage.userName.getText();

        Assert.assertEquals(usernameInProfileMenu, actualUserNameText);
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


    //Edited
    @Given("The user logs in as a {string}")
    public void the_user_logs_in_as_a(String userType) {
        loginPage.loginAsUserType(userType);
    }

    @When("The user enters a valid username")
    public void the_user_enters_a_valid_username() {
        loginPage.userEntersValidUsername();
    }

    @When("The user enters invalid username")
    public void the_user_enters_invalid_username() {
        loginPage.invalidUsername();
    }

    @When("The user enters a valid password")
    public void the_user_enters_a_valid_password() {
        loginPage.userEntersValidPassword();
    }

    @When("The user enters invalid password")
    public void the_user_enters_invalid_password() {
        loginPage.userEntersInvalidPassword();
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.loginBtn.click();
    }

    @When("The user enters username {string}")
    public void the_user_enters_username(String username) {
        loginPage.loginInput.sendKeys(username);
    }

    @When("The user enters password {string}")
    public void the_user_enters_password(String password) {
        loginPage.passInput.sendKeys(password);
    }

    @Then("The user should be redirected the Portal Page")
    public void the_user_should_be_redirected_the_portal_page() {
        String actualPageTitle = dashboardPage.getPageTitle();
        String expectedPageTitle = "Portal";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));
    }

    @Given("The user sees {string} link")
    public void the_user_sees_link(String rememberMeText) {
        String actualText = loginPage.rememberMeLabel.getText();
        Assert.assertEquals(rememberMeText, actualText);
    }

    @Given("the link is clickable")
    public void the_link_is_clickable() {
        loginPage.checkBox.click();
        Assert.assertTrue(loginPage.checkBox.isSelected());
    }

}
