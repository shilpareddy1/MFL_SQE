package org.naic.mfl.se.challenge;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.naic.mfl.se.challenge.pages.AccountRegistrationPage;
import org.naic.mfl.se.challenge.pages.LandingPage;
import org.naic.mfl.se.challenge.pages.SignonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest {
	WebDriver driver;
	WebDriverWait wait;

	String existingUserEmail = "mflsqe@naic.org";
	String existingUserPassword = "mflsqe1234";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10, 50);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void signInTestPOM() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.navigateToLogin();
		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";

		SignonPage signinPage = new SignonPage(driver);
		signinPage.clickToCreateNewAccount(email);
		String name = "Firstname";
		String surname = "Lastname";
		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		registrationPage.ClickToCreateAccount(name, surname);

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		assertEquals(heading.getText(), "MY ACCOUNT");
		assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);
		assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

	@Test
	public void logInTestPOM() {
		String fullName = "mfl sqe";
		SignonPage signinPage = new SignonPage(driver);
		signinPage.clickToSignIn(existingUserEmail, existingUserPassword);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		assertEquals("MY ACCOUNT", heading.getText());
		assertEquals(fullName, driver.findElement(By.className("account")).getText());
		assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

	@Test
	public void checkoutTestPOM() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.navigateToLogin();
		SignonPage signinPage = new SignonPage(driver);
		signinPage.clickToSignIn(existingUserEmail, existingUserPassword);
		landingPage.checkoutAfterSignin();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		assertEquals("ORDER CONFIRMATION", heading.getText());
		assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText()
				.contains("Your order on My Store is complete."));
		assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
	}
}
