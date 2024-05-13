package com.max;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class AbstractUITest {

    private static FileInputStream config;
    private static Properties prop = new Properties();
    protected static WebDriver webDriver;
    private static ChromeOptions chromeOptions;
    @BeforeEach
    public void init() {

        try {
            config = new FileInputStream("./src/test/java/resources/properties.properties");
            prop.load(config);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(chromeOptions);

        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }

    public String getLoginURL(){
        return this.prop.getProperty("LOGIN_URL");
    }
    @AfterEach
    public void closeWEbDriver(){
        webDriver.close();
    }


}
