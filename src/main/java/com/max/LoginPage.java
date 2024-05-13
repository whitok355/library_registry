package com.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement passInput;

    @FindBy(xpath = "//input[@data-testid='login-submit']")
    private WebElement btnSubmit;

    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
    public void loginNotEmailLogin(){
        emailInput.sendKeys("login");
        passInput.sendKeys("password");
        btnSubmit.click();
    }

    public void loginWithoutPassword(){
        emailInput.sendKeys("login@login.ru");
        btnSubmit.click();
    }
}
