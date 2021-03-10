package org.selenium.cucumber.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.selenium.cucumber.bdd.driver.DriverManager;

public class Hooks {
    DriverManager driverManager=new DriverManager();
    @Before
    public void setUp(){
        driverManager.openBrowser();
    }
    @After
    public void tearDown(){
        driverManager.closeBrowser();
    }
}

