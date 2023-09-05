package com.pages;

import org.openqa.selenium.WebElement
;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ContactsPage {

 @FindBy(xpath="//span[contains(text(),'Contacs')]")
 WebElement contacts;
 
 public ContactsPage() {
	 PageFactory.initElements(BaseClass.getDriver(), this);
 }

 public boolean verifyContactsPage() {
	 return contacts.isDisplayed();
 }

}
