package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


public class AfterSignInPage  {
	
	 @FindBy(xpath="//span[text()='Contacts']")
	 WebElement contacts;
	 @FindBy(xpath="//span[text()='Deas']")
	 WebElement deals;
	
	public AfterSignInPage() {
		 PageFactory.initElements(BaseClass.getDriver(), this);
	 }
	
	public ContactsPage contacts()   {
		 contacts.click();
		 return new ContactsPage();
}
	 public void deals() {
		 deals.click();
	    
	 }
}

