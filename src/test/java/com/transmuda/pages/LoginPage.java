package com.transmuda.pages;

import com.transmuda.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy (linkText = "Forgot your password?")
    public WebElement forgotYourPasswordLink;

    @FindBy (className = "custom-checkbox__text")
    public WebElement rememberMeOnThisComputerCheckBox;




    public ConfigurationReader driver;

    public void goLoginPage(){
        ConfigurationReader.getProperty(ConfigurationReader.getProperty("url"));
    }

    public void loginAsUserType(String userType){

        String password = "";
        String username = "";

        if (userType.equals("Driver")){
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        } else if (userType.equals("Sales Manager")) {
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        } else if (userType.equals("Store Manager")) {
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginWithCredentials(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }



}
