package com.calidadpruebas.steps;

import org.openqa.selenium.WebDriver;

import com.calidadpruebas.pages.LoginActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {
    @Managed(driver = "edge")
    WebDriver driver;

    @Steps
    LoginActions login;


    @Given("the user is on the Facebook login page")
    public void theUserIsOnTheFacebookLoginPage() {
        login.openLoginPage();
    }

    @When("^the user enters valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserEntersValidCredentials(String username, String password) {
        login.enterCredentials(username, password);
    }

    @When("^the user enters invalid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserEntersInvalidCredentials(String username, String password) {
        login.enterCredentials(username, password);
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        login.verifySuccessfulLogin();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        login.verifyUnsuccessfulLogin();
    }
}
