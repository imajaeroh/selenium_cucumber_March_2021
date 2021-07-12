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

import net.masterthought.cucumber.json.Output;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element library
	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@name='login']")
	WebElement SIGNIN_BUTTON_FIELD;
	//interactive actions
	
	public void insertUserName(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}	
		public void enterCredentials(String userName,  String password) {
			USERNAME_FIELD.sendKeys(userName);
			PASSWORD_FIELD.sendKeys(password);
	}
	
	
	public void clickOnSigninButton() {
		SIGNIN_BUTTON_FIELD.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
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
