package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    // tests
@Test
public void successfulLogin(){
    new LoginPage(driver)
            .EnterUsername("standard_user")
            .enterPassword("secret_sauce")
            .clickButton()
            .assertSuccessfulLoginPages();
}




    // configurations
@BeforeMethod
    public void sutUp(){

    EdgeOptions options =new EdgeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    driver = new EdgeDriver(options);

    new LoginPage(driver).navigateLoginPage();
}

@AfterMethod
    public void tearDown(){

    driver.quit();
}





}
