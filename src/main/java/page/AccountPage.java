package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {
	WebDriver driver;
	
	public AccountPage(WebDriver driver ) {
	this.driver = driver;
		}
	
	// element Library
//	@FindBy(how = How.XPATH, using = "//*[@id='username']")
//	WebElement USERNAME_FIELD;
//	@FindBy(how = How.XPATH, using = "//*[@id='password']")
//	WebElement PASSWORD_FIELD;
//	@FindBy(how = How.XPATH, using = "//*[@name='login']")
//	WebElement SIGNIN_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a")
	WebElement Bank_Cash_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[10]/ul/li[1]/a")
	WebElement NewAccount_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='account']")
	WebElement AccountTitle_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='description']")
	WebElement Description_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='balance']")
	WebElement InitialBalance_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='account_number']")
	WebElement AccountNumber_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='contact_person']")
	WebElement ContactPerson_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='contact_phone']")
	WebElement Phone_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='ib_url']")
	WebElement InternetBanking_url_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement ClickOnSubmitButton_locator;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]")
	WebElement Account_Validation_Page;
	
	
//	public void enterCredentials(String userName,  String password) {
//		USERNAME_FIELD.sendKeys(userName);
//		PASSWORD_FIELD.sendKeys(password);
//}
//
//	public void clickOnSignInButton() {
//		SIGNIN_BUTTON_FIELD.click();
//	}

		public void clickOnBankCashLocator() {
			Bank_Cash_locator.click();
			
		}
		
		public void clickOnNewAccountLocator() {
			NewAccount_locator.click();
		}
		
		public void enterAccountTitle(String accountTitle) throws InterruptedException {
//			Thread.sleep(5000);
			AccountTitle_locator.sendKeys(accountTitle);
		}
		public void enterAccountDescription(String description) throws InterruptedException {
			Description_locator.sendKeys(description);
//			Thread.sleep(2000);
		}
		public void enterinitialBalance(String initialBalance) throws InterruptedException {
			InitialBalance_locator.sendKeys(initialBalance);
//			Thread.sleep(2000);
		}
		public void enteraccountNumber(String accountNumber) throws InterruptedException {
			AccountNumber_locator.sendKeys(accountNumber);
//			Thread.sleep(2000);
		}
		public void entercontactPersons(String contactPersons) throws InterruptedException {
			ContactPerson_locator.sendKeys(contactPersons);
//			Thread.sleep(2000);
		}
		public void enterphone(String phone) throws InterruptedException {
				Phone_locator.sendKeys(phone);
//				Thread.sleep(2000);
			}
		public void enterinternetBanking(String internetBanking) throws InterruptedException {
				InternetBanking_url_locator.sendKeys(internetBanking);
//				Thread.sleep(10000);
				}
		
		public void clickOnSubmitButton() throws InterruptedException {
			ClickOnSubmitButton_locator.click();
			Thread.sleep(1000);
		}
		
		public void accountCreatedSuccessfullyOrAccountAlreadyExist() {
			String validationPage =Account_Validation_Page.getText();
			System.out.println("========================"+validationPage);	
		}

		public void takeScreenShotAtEndOfTest(WebDriver driver) throws IOException {
			TakesScreenshot ts = ((TakesScreenshot)driver);
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
			Date date = new Date();
			String label = formatter.format(date);
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(sourceFile, new File(currentDir +"/screenshots/" +label+ ".png" ));
			
		}

}



