package org.naic.mfl.se.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
	}

	public void checkoutAfterSignin() {
		WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
		driver.findElement(By.name("processCarrier")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button")))
				.click();
	}

}
