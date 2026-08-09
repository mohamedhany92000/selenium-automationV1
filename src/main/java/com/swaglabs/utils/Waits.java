package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
      // present     Visible    Clickble

    private Waits(){

    }


      public static WebElement waitForElementPresent(WebDriver driver, By locator) {

          return new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(driver1 -> driver1.findElement(locator));
      }


       // wait for  the element visible

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element= waitForElementPresent(driver , locator);
                    return element.isDisplayed() ? element : null;

                });
    }

    // wait for  the element Clickable

    public static WebElement waitForElementClickble(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element= waitForElementVisible(driver , locator);
                    return element.isEnabled() ? element : null;

                });
    }
}
