package com.stepDefinitions;


import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef  {
   private HomePage homePage;
   private LoginPage loginPage;
   
  
	
    @Given("^user is on home page$")
	public void user_is_on_home_page() throws IOException{
		BaseClass.getDriver().get(" https://freecrm.com/ ");
	}

	@When("^user clicks on LogIN$")
	public void user_clicks_on_LogIN() throws InterruptedException {
		homePage=new HomePage();
		loginPage=homePage.loginPage();
	}

	@When("^user enters username \"(.*)\" and password \"(.*)\" and clicks on login button$")
	public void user_enters_username_and_password(String username, String pass){
		loginPage.SignIn(username, pass);
		
	}

	@Then("^user is signed in and verify title\\.$")
	public void user_is_signed_in_and_verify_title() {
		String actual=BaseClass.getDriver().getTitle();
		Assert.assertEquals("Cogmento CRM", actual);
	}
	
	

	
}
