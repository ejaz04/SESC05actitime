package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public  void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Reporter.log("CreateCustomer",true);
		Assert.fail();
		FileLib f=new FileLib();
		String customerName = f.getExceldata("CreateCustomer", 1, 2);
		String customerDescprition = f.getExceldata("CreateCustomer", 1, 3);
		Thread.sleep(3000);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getCustomerNameTbx().sendKeys(customerName);
		t.getCustomerDescriptionTbx().sendKeys(customerDescprition);
		t.getSelectCustomerDD().click();
		t.getOurCompanyTx().click();
		t.getCreateCustomerBtn().click();
		
		
	    WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(),customerName));
		String actualtext = t.getActualCustomer().getText();
		 Assert.assertEquals(actualtext, customerName);
	}
	}

	
	

