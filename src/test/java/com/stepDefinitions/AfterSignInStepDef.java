package com.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.AfterSignInPage;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AfterSignInStepDef {
	private HomePage homePage;
	private LoginPage loginPage;
	private	AfterSignInPage afterSignInPage;
	private	ContactsPage contactsPage;
	 
	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable dataTable) throws InterruptedException {
		 List<Map<String, String>> credentialsList = dataTable.asMaps(String.class, String.class);

			for(Map<String, String> data:credentialsList) {
			BaseClass.getDriver().get(" https://freecrm.com/ ");
			homePage= new HomePage();
			loginPage=homePage.loginPage();
			afterSignInPage=loginPage.SignIn(data.get("username"),data.get("password"));
			Thread.sleep(10000);
			}
	}
	
	@Given("^user is on AfterSignInPage$")
	public void user_is_on_AfterSignInPage()  {
		String title=BaseClass.getDriver().getTitle();
		System.out.println(title);
	}

	@When("^user clicks on contacts$")
	public void user_clicks_on_contacts() throws InterruptedException {
		contactsPage=afterSignInPage.contacts();
		Thread.sleep(6000);
	}

	@Then("^contacts page is opened$")
	public void contacts_page_is_opened(){
	   boolean b=contactsPage.verifyContactsPage();
	   Assert.assertTrue(b);
	}
	
	
	@When("^user clicks on deals$")
	public void user_clicks_on_deals() {
		afterSignInPage.deals();
	}

	@Then("^deals page is opened$")
	public void deals_page_is_opened() {

}
}
