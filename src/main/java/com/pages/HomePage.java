package com.pages;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.base.BaseClass;
 
public class HomePage {
	
	@FindBy(linkText="Sign Up")
	WebElement logIn;
	
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public LoginPage loginPage() throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
	 js.executeScript("arguments[0].click();", logIn);
		//logIn.click();
	    
		

		return new LoginPage();
	}
}
