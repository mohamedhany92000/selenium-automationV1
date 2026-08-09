package com.swaglabs.pages;

import com.swaglabs.utils.BrawserActions;
import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {


     // Locators   data-test="error"
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBotton = By.id("login-button");
    private final By errorMassage = By.cssSelector("[data-test='error']");

     //constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



//    Navigate Login page

    public void navigateLoginPage(){

        BrawserActions.navigateToUrl(driver,"https://www.saucedemo.com/");
    }

    // Action Wait  scroll  find  send keys

    public LoginPage EnterUsername(String username){

        ElementActions.sendData(driver,this.username,username);
        return this;
    }



    public LoginPage enterPassword ( String password){
        ElementActions.sendData(driver,this.password,password);
        return this;

    }

    public  LoginPage clickButton(){
       ElementActions.clickElement(driver,loginBotton);
       return this;

    }

    public String getErrorMassage(){
     return ElementActions.getText(driver,errorMassage);

    }
    // Validations

    public LoginPage assertSuccessfulLoginPages(){
         Assert.assertEquals(BrawserActions.getCarrantURL(driver),"https://www.saucedemo.com/inventory.html");
         return this;
    }


    public LoginPage assertUnSuccessfulLoginPages(){
        Assert.assertEquals(getErrorMassage(),"Epic sadface: Username and password do not match any user in this service");
        return this;

    }

}
