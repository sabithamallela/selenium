package org.selenium.cucumber.bdd.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.argos.co.uk");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
    }
    public void closeBrowser(){
        driver.quit();
    }
}
