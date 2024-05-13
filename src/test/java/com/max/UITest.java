package com.max;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class UITest extends AbstractUITest{

    private LoginPage loginPage;

    @BeforeEach
    public void createLoginPage(){
        webDriver.get(getLoginURL());
        loginPage = new LoginPage(getWebDriver());
    }

    @Test
    void testGBNotEmailLogin() {
        loginPage.loginNotEmailLogin();

        webDriver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("login");
        webDriver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        webDriver.findElement(By.xpath("//input[@data-testid='login-submit']")).click();

        Assertions.assertFalse(webDriver.findElements(By.xpath("//ul[@id='parsley-id-5']//child::li")).isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        loginPage.loginWithoutPassword();

        webDriver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("login@login.ru");
        webDriver.findElement(By.xpath("//input[@data-testid='login-submit']")).click();

        Assertions.assertFalse(webDriver.findElements(By.xpath("//ul[@id='parsley-id-7']//child::li")).isEmpty());
    }


}
