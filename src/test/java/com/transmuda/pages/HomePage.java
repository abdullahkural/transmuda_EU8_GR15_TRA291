package com.transmuda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public WebDriver driver;

    @FindBy(className = "oro-subtitle")
    public WebElement pageSubTitle;

    @FindBy (className = "dropdown-toggle")
    public WebElement JohnDoeDropdown;

    @FindBy (className = "no-hash")
    public WebElement logout;

    @FindBy (xpath = "//a[@href='/user/logout']")
    public WebElement logOutNew;




}
