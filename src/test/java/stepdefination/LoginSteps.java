package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Base;
import pages.Login;

public class LoginSteps extends Base {

    Login loginPage;
    String user = "";

    @Given("^I open awwwards$")
    public void awwwards() {
        Base.initialization();
        loginPage = new Login();
        loginPage.launchwebsite();

    }

    @Then("^I click on Login$")
    public void i_click_on_login() {
        loginPage.ClickLogin();
    }

    @Then("^click on LoginNow$")
    public void click_on_loginnow() {
        loginPage.Signin();
    }

    @Then("click on Logout")
    public void i_click_on_Logout() {
        loginPage.logout(user);
    }

    @And("^I enter (.+) as (.+)$")
    public void i_enter(String username, String password) {
        user = username;
        loginPage.SetUser(username);
        loginPage.SetPassword(password);

    }

    @Then("^click on polawebsite$")
    public void click_on_polawebsite() {
        loginPage.polawebsite();
    }


    @Then("^I get image title$")
    public void i_get_image_title() {
        loginPage.getImageTitle();
    }

    @Then("^I navigate to new window$")
    public void i_navigate_to_new_window() {
        loginPage.switchtonewwindow();
    }
}
