package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


public class LoginPage {
	
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[text()='Login']")
	WebElement SignIn;

	
	 public LoginPage() {
		 PageFactory.initElements(BaseClass.getDriver(), this);
	 }
	  
	 public AfterSignInPage SignIn(String username,String pass) {
		 email.sendKeys(username);
		 password.sendKeys(pass);
		 SignIn.click();
		 return new AfterSignInPage();
	 }
	 
	    }
		
