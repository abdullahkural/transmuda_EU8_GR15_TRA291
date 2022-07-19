package com.transmuda.utilities;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {



    public static void sleep(int second){
        second *= 1000;

        try {

            Thread.sleep(second);

        }catch (InterruptedException e ) {

        }
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void pressEnterKey(){
        Actions actions = new Actions(Driver.getDriver()).sendKeys(Keys.ENTER);
    }


}
