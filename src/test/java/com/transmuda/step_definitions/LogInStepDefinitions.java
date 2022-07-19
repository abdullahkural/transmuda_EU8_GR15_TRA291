package com.transmuda.step_definitions;

import com.github.javafaker.Faker;
import com.transmuda.pages.HomePage;
import com.transmuda.pages.LoginPage;
import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.ConfigurationReader;
import com.transmuda.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LogInStepDefinitions {

    public LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();
    Faker faker = new Faker();
    Driver driver = new Driver();


    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    //Scenario 1
    //____________________________________________________________________________________________________

    @When("The user logs in as a driver")
    public void the_user_logs_in_as_a_driver() {
        System.out.println("Scenario - 1 \n");
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.loginButton.click();
    }

    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {
        BrowserUtils.sleep(2);
        String expectedSubTitle = "Quick Launchpad";
        String actualSubTitle = homePage.pageSubTitle.getText();
        assertEquals(expectedSubTitle,actualSubTitle);
    }

    @When("The user logs in as a sales manager")
    public void the_user_logs_in_as_a_sales_manager() {
        BrowserUtils.sleep(2);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
        loginPage.loginButton.click();
    }

    @Then("The user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        BrowserUtils.sleep(2);
        String expectedSubTitle = "Dashboard";
        String actualSubTitle = homePage.pageSubTitle.getText();
        assertEquals(expectedSubTitle,actualSubTitle);
    }

    @When("The user logs in as a store manager")
    public void the_user_logs_in_as_a_store_manager() {
        BrowserUtils.sleep(2);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
        loginPage.loginButton.click();
    }

    //Scenario 2
    //____________________________________________________________________________________________________

    @When("user copy the url after login and log out, paste the same url to browser")
    public void user_copy_the_url_after_login_and_log_out_paste_the_same_url_to_browser() {
        System.out.println("Scenario - 2 \n");
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.loginButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String homePageUrl = Driver.getDriver().getCurrentUrl();
        homePage.JohnDoeDropdown.click();
        homePage.logout.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(homePageUrl);
        Actions actions = new Actions(Driver.getDriver()).sendKeys(Keys.ENTER);
    }

    @Then("The system shouldn't allow users to access the application")
    public void the_system_shouldn_t_allow_users_to_access_the_application() {
        BrowserUtils.sleep(2);
        String expectedSubTitle = "Dashboard";
        String actualSubTitle = homePage.pageSubTitle.getText();
        Assert.assertNotEquals(expectedSubTitle, actualSubTitle);
    }

    //Scenario 3
    //____________________________________________________________________________________________________

    @When("The user logs in with invalid credentials")
    public void theUserLogsInWithInvalidCredentials() {
        System.out.println("Scenario - 3 \n");
        BrowserUtils.sleep(2);
        loginPage.usernameInput.sendKeys(faker.name().username());
        loginPage.loginButton.click();
    }

    @Then("Please fill out this field message should be displayed for any empty field")
    public void pleaseFillOutThisFieldMessageShouldBeDisplayedForAnyEmptyField() {
        BrowserUtils.sleep(2);
        String actualMessage  = loginPage.usernameInput.getAttribute("required");
        System.out.println("actualMessage = " + actualMessage);
        //boolean required = Boolean.parseBoolean(actualMessage);
        assertEquals("true",actualMessage);
        //loginPage.usernameInput.getAttribute("validationMessage"); metodu warning attribute u bulur
    }

    //Scenario 4
    //____________________________________________________________________________________________________
    @When("The user logs in with {string}")
    public void theLogsInWith(String userName) {
        loginPage.usernameInput.sendKeys(userName);
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


    }

    @And("user types on the passwordInputBox with {string}")
    public void userTypesOnThePasswordInputBoxWith(String password) {
        loginPage.passwordInput.sendKeys(password);
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Then("The user should see their bullet sign")
    public void theUserShouldSeeTheirBulletSign() {
        String actualType = loginPage.passwordInput.getAttribute("type");
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        assertEquals("password", actualType);
    }


    //Scenario 5
    //____________________________________________________________________________________________________

    @When("The user click Forgot your password link on login page")
    public void theUserClickForgotYourPasswordLinkOnLoginPage() {
        System.out.println("Scenario - 5 \n");
        BrowserUtils.sleep(2);
        loginPage.forgotYourPasswordLink.click();
    }

    @Then("The user land on the Forgot Password page")
    public void theUserLandOnTheForgotPasswordPage() {
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";
        assertEquals(expectedTitle, actualTitle);
    }



    //Scenario 6
    //____________________________________________________________________________________________________

    @When("Remember me on this computer checkbox is clicked after valid credentials is provided")
    public void remember_me_on_this_computer_checkbox_is_clicked_after_valid_credentials_is_provided() {
        System.out.println("Scenario - 6 \n");
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.rememberMeOnThisComputerCheckBox.click();
        loginPage.loginButton.click();
    }

    @When("The user logs in next time")
    public void the_user_logs_in_next_time() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }

    @Then("The user log in without providing credentials")
    public void the_user_log_in_without_providing_credentials() {
        BrowserUtils.sleep(2);
        String expectedSubTitle = "Quick Launchpad";
        String actualSubTitle = homePage.pageSubTitle.getText();
        assertEquals(expectedSubTitle, actualSubTitle);
    }

    //Scenario 7
    //____________________________________________________________________________________________________

    @When("The user clicks on Username input box and hits Enter button")
    public void theUserClicksOnUsernameInputBoxAndHitsEnterButton() {
        System.out.println("Scenario - 7 \n");
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username") + Keys.ENTER);

    }

    @Then("The cursor appears on Password input box, hit Enter again, Login button gets clicked")
    public void theCursorAppearsOnPasswordInputBoxHitEnterAgainLoginButtonGetsClicked() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        WebElement actualActiveElement = (WebElement)jse.executeScript("return document.activeElement;");
        assertEquals("prependedInput2", actualActiveElement.getAttribute("id"));

    }


    //Scenario 8
    //____________________________________________________________________________________________________

    @Then("The driver can see the username in the profile menu")
    public void theDriverCanSeeTheUsernameInTheProfileMenu() {
        BrowserUtils.sleep(2);
        String actualUsername = homePage.JohnDoeDropdown.getText();
        String expectedUsername = "user1";
        assertEquals(expectedUsername, actualUsername);
    }

    @Then("The sales manager can see the username in the profile menu")
    public void theSalesManagerCanSeeTheUsernameInTheProfileMenu() {
        BrowserUtils.sleep(2);
        String actualUsername = homePage.JohnDoeDropdown.getText();
        String expectedUsername = "salesmanager101";
        assertEquals(expectedUsername, actualUsername);
    }

    @Then("The store manager can see the username in the profile menu")
    public void theStoreManagerCanSeeTheUsernameInTheProfileMenu() {
        BrowserUtils.sleep(2);
        String actualUsername = homePage.JohnDoeDropdown.getText();
        String expectedUsername = "storemanager51";
        assertEquals(expectedUsername, actualUsername);
    }



}
