package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryCloudLoginPage {

    public TryCloudLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="user")
    public WebElement inputUsername;

    @FindBy (id="password")
    public WebElement inputPassword;

    @FindBy (id="submit-form")
    public WebElement loginButton;

    @FindBy (id="lost-password")
    public WebElement forgotPassword;


    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
}
