package org.selenium.cucumber.bdd;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.selenium.cucumber.bdd.pageobject.BasketPage;
import org.selenium.cucumber.bdd.pageobject.HomePage;
import org.selenium.cucumber.bdd.pageobject.ProductDecPage;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class SmokeSuitsTest {
    WebDriver driver;
    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private BasketPage basketPage = new BasketPage();
    private ProductDecPage productDecPage = new ProductDecPage();

    @Test
    public void searchTest() {
        String searchTerm = "nike";
        homePage.doSearch(searchTerm);//homepage is object calling a method "dosearch"
        String actual = resultsPage.getProductTitle();
        assertThat(actual, containsString(searchTerm));
        String urlActual = resultsPage.getCurrentUrl();
        assertThat(urlActual, endsWith(searchTerm));
    }

    @Test
    public void basketTest() {
        Util util = new Util();
        String searchTerm = "nike";
        homePage.doSearch(searchTerm);
        util.sleep();
        String selectProductName = resultsPage.selectAnyProduct();//expected
        productDecPage.addProductToTrolley();
        util.sleep();
        productDecPage.goToTrolley();
        List<String> itemsInTrolley = basketPage.getAllItemsInBasket();//actual results
        assertThat(itemsInTrolley, hasItem(selectProductName));
    }

    @Test
    public void reviewTest() {

        Util util = new Util();
        String searchTerm = "nike";
        util.sleep();
        homePage.doSearch(searchTerm);
        Double expected = resultsPage.selectAnyRating();
        List<Double> actualRatingList = resultsPage.getAllProductsRating();
        assertThat(actualRatingList, everyItem(greaterThanOrEqualTo(expected)));

    }

    @Test
    public void sortTest() {
        Util util = new Util();
        String searchTerm = "nike";
        util.sleep();
        homePage.doSearch(searchTerm);
        resultsPage.selectLowToHigh();
        List<Double> actualProductPriceList = resultsPage.sortLowToHigh();
        List<Double> tempProductList = new ArrayList<>();//expected list.
        tempProductList.addAll(actualProductPriceList);
        Collections.sort(tempProductList);//collections is a class/collection is a method
        System.out.println(tempProductList);
        assertThat(actualProductPriceList, is(equalTo(tempProductList)));
    }


    @Test
    public void priceTest() {
        Util util = new Util();
        String searchTerm = "nike";
        util.sleep();
        homePage.doSearch(searchTerm);
        List<String> selectedRange = resultsPage.selectPriceRange();
        double min = Double.parseDouble(selectedRange.get(0));//expected
        double max = Double.parseDouble(selectedRange.get(1));//expected
        List<Double> actual = resultsPage.getPrices();

        assertThat(actual, both(everyItem(greaterThanOrEqualTo(min))).and(everyItem(lessThanOrEqualTo(max))));

    }

}
