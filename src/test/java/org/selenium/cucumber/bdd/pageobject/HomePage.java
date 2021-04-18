package org.selenium.cucumber.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.selenium.cucumber.bdd.driver.DriverManager;

public class HomePage extends DriverManager {
// to find elements
  public void doSearch(String searchTerm){
       driver.findElement(By.id("searchTerm")).sendKeys(searchTerm);
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
    }
    public String isOnHomePage(){
        return driver.getCurrentUrl();
    }
}

