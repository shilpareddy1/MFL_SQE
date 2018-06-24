package org.naic.mfl.se.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage {
	private WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {		 
		this.driver = driver;
	}

	public void ClickToCreateAccount(String name, String surname) {
		WebDriverWait wait = new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
        
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.id("passwd")).sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        driver.findElement(By.id("company")).sendKeys("Company");
        driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
        driver.findElement(By.id("address2")).sendKeys("zxcvb");
        driver.findElement(By.id("city")).sendKeys("Qwerty");
        select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("Qwerty");
        driver.findElement(By.id("phone")).sendKeys("12345123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");
        driver.findElement(By.id("alias")).sendKeys("hf");
        driver.findElement(By.id("submitAccount")).click();
	}
}
