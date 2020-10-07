package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.io.IOException;



public class LoginTest {
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	  @Test (priority = 1)
	  public void loginWithWrongPasswordTest() throws InterruptedException {
		  
		  lp.enterEmail(df.correctEmail);
		  lp.enterPassword(df.wrongPassword);
		  //String expectedErrmsg = "Invalid password. Please try again"; // instead of this 3 lines you can write the below line
		  //String actualErrmsg = lp.readPasswordErr();
		  //Assert.assertEquals(actualErrmsg, expectedErrmsg);
		  Assert.assertEquals(lp.readPasswordErr(),df.passwordErr);
		  //System.out.println(correctEmail);
		  //System.out.println(wrongEmail);
		  //System.out.println(wrongPassword);
		  //System.out.println(emailErr);
		 // System.out.println(passwordErr);
	  }
	 
	 
     @Test(priority = 2)
	  public void loginWithWrongEmailTest() throws InterruptedException {
	  
    	 lp.enterEmail(df.wrongEmail);
    	 Assert.assertEquals(lp.readEmailErr(), df.emailErr);
		
		
  }


  @BeforeMethod
  public void beforeMethod() throws IOException {
	 
	  
	
		lp.openBrowser();
		lp.openYahoo();
  }

  
  
  @AfterMethod
  public void afterMethod() {
	 //driver.close();
	 lp.closeBrowser();
  }

}
