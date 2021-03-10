package org.selenium.cucumber.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.cucumber.bdd.Util;
import org.selenium.cucumber.bdd.driver.DriverManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultsPage extends DriverManager {
    public String getProductTitle() {//search test
        return driver.findElement(By.cssSelector(".styles__SearchTerm-sc-1haccah-1")).getText();
    }

    public String getCurrentUrl() {//search test

        return driver.getCurrentUrl();
    }

    //basket test
    public String selectAnyProduct() {


        List<WebElement> productNames = driver.findElements(By.cssSelector(".ProductCardstyles__Title-gm8lcq-12"));

        int size = productNames.size();
        int randomNumber = new Util().randomNumber(size);
        WebElement selectProductElement = productNames.get(randomNumber);
        String selectProductName = selectProductElement.getText();//expected
        selectProductElement.click();
        return selectProductName;
    }

    public double selectAnyRating() {//for review test
        Util util = new Util();
        List<WebElement> filterRatingElements = driver.findElements(By.cssSelector(".styles__RatingLabel-sc-1ghu43i-3"));//expected value
        util.sleep();
        int size = filterRatingElements.size();
        int randomNumber = util.randomNumber(size);
        WebElement selectedWebElement = filterRatingElements.get(randomNumber);
        String selectedRatingValue = selectedWebElement.getText().substring(0, 1);//expected value
        double expected = Double.parseDouble(selectedRatingValue);
        util.sleep();
        System.out.println("select review filter=" + selectedRatingValue);
        selectedWebElement.click();
        return expected;

    }

    public List<Double> getAllProductsRating() {//review test
        Util util = new Util();
        List<Double> actualRatingList = new ArrayList<>();//actual values
        util.sleep();
        List<WebElement> ratingElements = driver.findElements(By.cssSelector("div[data-test='component-ratings']"));
        for (WebElement element : ratingElements) {
            String ratingValueInString = element.getAttribute("data-star-rating");
            double ratingInDouble = Double.parseDouble(ratingValueInString);
            actualRatingList.add(ratingInDouble);

        }
        return actualRatingList;
    }

    public List<String> selectPriceRange() {//price test
        Util util = new Util();
        List<WebElement> filterPrices = driver.findElements(By.cssSelector("label[name='price'] .Checkboxstyles__LabelValue-b61uwr-6"));//doubt

        util.sleep();
        int size = filterPrices.size();
        int randomNumber = new Util().randomNumber(size);
        WebElement selectPriceElement = filterPrices.get(randomNumber);
        String selectPrice = selectPriceElement.getText().replace("£", "");
        List<String> priceRangeList = Arrays.asList(selectPrice.split("-"));
        double min = Double.parseDouble(priceRangeList.get(0));//expected
        double max = Double.parseDouble(priceRangeList.get(1));
        selectPriceElement.click();
        return priceRangeList;//we need to return the value because

    }

    public List<Double> getPrices() {//price test
        Util util = new Util();
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-gm8lcq-14"));
        util.sleep();
        List<Double> actualProductPriceList = new ArrayList<>();//actual
        for (WebElement element : priceElements) {
            String productPriceInString = element.getText().replace("£", "");
            double actual = Double.parseDouble(productPriceInString);
            actualProductPriceList.add(actual);
            // return actualProductPriceList;
        }
        return actualProductPriceList;
    }

    public void selectLowToHigh() {//sortby
        Util util = new Util();
        driver.findElement(By.cssSelector("option[label='Price: Low - High']")).click();
        util.sleep();
    }

    public List<Double> sortLowToHigh() {//sortby

        Util util = new Util();
        List<Double> actualProductPriceList = new ArrayList<>();//actual list
        util.sleep();
        List<WebElement> productPriceElements = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-gm8lcq-14"));
        util.sleep();
        for (WebElement element : productPriceElements) {//for each
            String productPriceInString = element.getText().replace("£", "");
            double actual = Double.parseDouble(productPriceInString);//actual values
            actualProductPriceList.add(actual);

        }
        return actualProductPriceList;
    }
}
