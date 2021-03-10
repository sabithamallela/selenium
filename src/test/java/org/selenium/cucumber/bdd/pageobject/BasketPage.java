package org.selenium.cucumber.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.cucumber.bdd.driver.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends DriverManager {
    public List<String> getAllItemsInBasket() {
        List<String> itemsInTrolley = new ArrayList<>();
        List<WebElement> itemsInTrolleyWebElements = driver.findElements(By.cssSelector("a[data-e2e='product-name']")); //actual
//go to basket and find element for basket item right click and inspect on that element
        for (WebElement element : itemsInTrolleyWebElements) {
            //datatype variable:value
            //foreach
            String productInTrolley = element.getText();
            if (!productInTrolley.equals("")) {
                itemsInTrolley.add(productInTrolley);
            }
        }
        return itemsInTrolley;
    }
}
