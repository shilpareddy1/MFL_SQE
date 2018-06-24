package org.naic.mfl.se.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignonPage {
	private WebDriver driver;

	public SignonPage(WebDriver driver) {
 		this.driver = driver;
	}
	
	public void clickToSignIn(String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	public void clickToCreateNewAccount(String email) {
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
	}
	
}
