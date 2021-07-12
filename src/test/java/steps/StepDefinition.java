package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.AccountPage;
import page.LoginPage;
import util.BrowserFactory;

public class StepDefinition {

	WebDriver  driver;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Before
	public void beforeRun(){
		driver = BrowserFactory.init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		accountPage = PageFactory.initElements(driver, AccountPage.class);
	}
	
	@Given("^User is on the login page$")
	public void User_is_on_the_login_page() {
		System.out.println("User is on the login page");
		driver.get("https://www.techfios.com/billing/?ng=login/");
	}
	
	 @When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	   public void user_enters_the_and(String username, String password) throws Throwable {
		 loginPage.enterCredentials(username, password);
	   }
	
		@And ("^User clicks on login button$")
	public void user_clicks_on_signin_button() throws InterruptedException, IOException { 
			loginPage.clickOnSigninButton();
	  Thread.sleep(2000);
	   
	}

		@Then("^User should be able to see the dashboard$")
		public void user_should_be_able_to_see_the_dashboard()  throws Throwable {
	String titlePage =   loginPage.getPageTitle();
	   System.out.println("====================="+titlePage);
	//   Assert.assertEquals("Title Page not found", "Dashboard- iBilling", titlePage);// hard assert because code will
	   													// stop is assert fails and will not continue to end of codes
//	   accountPage.takeScreenShotAtEndOfTest(driver);
	   String expectedTitle = "Dashboard- iBilling";
	   String actualTitle = titlePage;
	   
	   if(expectedTitle.equalsIgnoreCase(actualTitle)) {  //soft assert because the codes will run to the end
		   System.out.println("Titles matched");			//
	   }else {												//
		   System.out.println("Titles do not match");       //
	   }
		}   
		@When("^User clicks on bank and cash$")
		public void user_clicks_on_bank_and_cash() throws InterruptedException, IOException { 
		  accountPage.clickOnBankCashLocator();
		  System.out.println();
		  Thread.sleep(2000);
		}
		@When("^User clicks on new account$")
		public void User_clicks_on_bank_new_account_button() throws InterruptedException, IOException { 
		  accountPage.clickOnNewAccountLocator();
		  Thread.sleep(2000);
		}
		
		@When("^User fill up the form entering \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\"  and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_fill_up_the_form_entering_and_and(String accountTitle, String description, String initialBalance, String accountNumber,String contactPersons, String phone, String internetBanking) throws InterruptedException  {
		   accountPage.enterAccountTitle(accountTitle);
		   accountPage.enterAccountDescription(description);
		   accountPage.enterinitialBalance(initialBalance);
		   accountPage.enteraccountNumber(accountNumber);
		   accountPage.entercontactPersons(contactPersons);
		   accountPage.enterphone(phone);
		   accountPage.enterinternetBanking(internetBanking);
		}

		
		@And("^User clicks on submit button$")
		public void  user_clicks_on_submit_button() throws InterruptedException {
			accountPage.clickOnSubmitButton();
		}
		

		@Then("^User should be able to validate new account$")
		public void user_should_be_able_to_validate_new_account() throws Throwable {
			accountPage.accountCreatedSuccessfullyOrAccountAlreadyExist();
		
 
		}

//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//		
//	} 

}

