package org.selenium.cucumber.bdd.pageobject;


import org.openqa.selenium.By;
import org.selenium.cucumber.bdd.Util;
import org.selenium.cucumber.bdd.driver.DriverManager;

public class ProductDecPage extends DriverManager {
    public void addProductToTrolley() {
        Util util = new Util();

        driver.findElement(By.cssSelector("button[data-test='add-to-trolley-button-button']")).click();
        util.sleep();
    }


    public void goToTrolley() {
        driver.findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();//find element for go to trolley
    }
}


