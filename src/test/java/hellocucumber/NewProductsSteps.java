package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Login;
import pages.NavigateMethods;
import pages.NewProducts;

public class NewProductsSteps extends Base {

	
	
	NewProducts newProducts = new NewProducts();
	Login loginPage;
	NavigateMethods navigateMethods = new NavigateMethods();

    String Allnewnextpagestart = "//*[@id=\"category-root\"]/div[2]/div[2]/div[2]/div/div/div/li[";
    String Allnewnextpageend = "]/a";	
	
	 @Given("^I open inthestyle$")
     public void i_open_amazon() {
        Base.initialization();
        loginPage = new Login();
        loginPage.LaunchLoginPage();
     }
	 
	 @And("^I Mousehover (.*)$")
	 public void i_mousehover(String model) {
		 System.out.println("model is venu ::: "+model);

	     // Write code here that turns the phrase above into concrete actions
		 newProducts.moveHover(model);
}


	 @Then("^Click on (.*)$")
	 public void Click_on_AllNew(String submodel) {
	     // Write code here that turns the phrase above into concrete actions
		 System.out.println("submodel ::: "+submodel);
		 newProducts.AllNew(submodel);
}
	 @And("^I scrooldown$")
	 public void i_scrolldown() {
	     // Write code here that turns the phrase above into concrete actions
		 newProducts.scrolldown();
	 }
   
    @When("^I InspectProduct product$")
    public void i_InspectProduct_product() throws InterruptedException {
	     // Write code here that turns the phrase above into concrete actions
		 newProducts.InspectProduct();
}

    @Then("^I Click on Allnewnextpage$")
    public void i_click_on_Allnewnextpage() {
	     // Write code here that turns the phrase above into concrete actions
		 newProducts.Allnewnextpage(Allnewnextpagestart,Allnewnextpageend);
	 }
    @When("^I scrollPage (top)$")
	public void scroll_page(String to) throws Exception
	{
		navigateMethods.scrollPage(to);
	}



}
