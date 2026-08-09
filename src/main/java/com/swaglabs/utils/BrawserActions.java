package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;

public class BrawserActions {

    private BrawserActions() {
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);

    }


    public static String getCarrantURL(WebDriver driver){

         return driver.getCurrentUrl();
    }


}
