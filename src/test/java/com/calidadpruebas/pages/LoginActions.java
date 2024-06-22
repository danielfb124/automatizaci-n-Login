package com.calidadpruebas.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginActions extends UIInteractionSteps {

    private String loginPageURL = "https://www.facebook.com/login";

    
    public void openLoginPage() {
        openUrl(loginPageURL);
    }

    @Step("Enter credentials {0} and {1}")
    public void enterCredentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pass"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginbutton"))).click();
    }

    @Step("Verify successful login")
    public void verifySuccessfulLogin() {
        try {
            if (!$(By.className("x1lliihq")).isDisplayed()) {
                throw new AssertionError("User profile name not displayed after login");
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("User profile name not found after login");
        }
    }
    

    @Step("Verify unsuccessful login")
    public void verifyUnsuccessfulLogin() {
        try {
            if (!$(By.className("_akzt")).isDisplayed()) {
                throw new AssertionError("Error message not displayed after unsuccessful login attempt");
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error message not found after unsuccessful login attempt");
        }
    }
}
