package hellocucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Login;
import pages.Products;

public class LoginSteps extends Base {

    Login loginPage;
    Products productsPage;

    @Given("I open amazon")
    public void i_open_amazon() {
        Base.initialization();
        loginPage = new Login();

        loginPage.LaunchLoginPage();
    }
    
    @Then("I click on Sigin")
    public void i_click_on_Sigin() {
    	loginPage.Signin();
    }
    @When("I Enter Email {string}")
    public void iEntertheUsername(String arg0) {
        loginPage.SetUser(arg0);
    }
    
    @Then ("I Enter Password {string}")
    public void iEnterthepassword(String arg0) {
        loginPage.SetPassword(arg0);
    }
    @And("I click on Continue")
    public void i_click_on_continue() {
        loginPage.ClickLogin();
    }

    @Then("the user is granteed to the website")
    public void the_user_is_granteed_to_the_website() {
        productsPage = new Products();
        assert productsPage.IsInScreen();
        Base.closeBrowser();
    }

    @Then("the user is not allowed to login the website")
    public void theUserIsNotAllowedToLoginTheWebsite() {
        assert loginPage.IsToast();
        Base.closeBrowser();
    }
}
