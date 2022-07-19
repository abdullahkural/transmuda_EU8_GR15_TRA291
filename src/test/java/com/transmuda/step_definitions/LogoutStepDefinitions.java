package com.transmuda.step_definitions;

import com.transmuda.pages.HomePage;
import com.transmuda.pages.LoginPage;
import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.ConfigurationReader;
import com.transmuda.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LogoutStepDefinitions {

    public LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();
    Driver driver = new Driver();
    Actions actions = new Actions(Driver.getDriver());
    String homePageUrl;


    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.loginButton.click();
        BrowserUtils.sleep(1);
    }


    //Scenario - 1
    //----------------------------------------------------------------------------------
    @When("The user click logout button inside profile")
    public void theUserClickLogoutButtonInsideProfile() {
        homePage.JohnDoeDropdown.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.logOutNew.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }

    @Then("The user should end up in the login page")
    public void theUserShouldEndUpInTheLoginPage() {
        BrowserUtils.sleep(4);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Login";
        assertEquals(expectedTitle, actualTitle);
    }

    //Scenario - 2
    //----------------------------------------------------------------------------------
    @When("The user clicks the step back button")
    public void theUserClicksTheStepBackButton() {
        homePage.JohnDoeDropdown.click();
        homePage.logout.click();
        Driver.getDriver().navigate().back();
    }

    @Then("The user should not go to home page again")
    public void theUserShouldNotGoToHomePageAgain() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Login";
        assertEquals(expectedTitle, actualTitle);
    }

    //Scenario - 3
    //----------------------------------------------------------------------------------
    @When("The user close the tab")
    public void theUserCloseTheTab() {
        homePageUrl = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //actions.keyDown(Keys.CONTROL).sendKeys(Keys.F4).build().perform();
        Driver.closeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("The user must be logged out")
    public void theUserMustBeLoggedOut() {
        Driver.getDriver().get(homePageUrl);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Quick Launchpad";
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertNotEquals(expectedTitle,actualTitle);

    }

    //Scenario - 4
    //----------------------------------------------------------------------------------
    @When("The user is away from keyboard at least for three min")
    public void theUserIsAwayFromKeyboardAtLeastForThreeMin() {
        BrowserUtils.sleep(190);
    }
}
