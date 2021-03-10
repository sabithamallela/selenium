package org.selenium.cucumber.bdd.step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.selenium.cucumber.bdd.pageobject.HomePage;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SortStepDef {
    String searchTerm;
HomePage homePage=new HomePage();
ResultsPage resultsPage =new ResultsPage();
    @When("^I search for product \"([^\"]*)\"$")//search different products
    public void iSearchForProduct(String item){
        homePage.doSearch(item);
       searchTerm=item;}

    @And("^I sort them low to high$")
    public void iSortThemLowToHigh() {
        resultsPage.selectLowToHigh();

    }

    @Then("^I should view products within the respective order$")
    public void iShouldViewProductsWithinTheRespectiveOrder() {
       List<Double> actualProductPriceList =resultsPage.sortLowToHigh();
        List<Double> tempProductList = new ArrayList<>();//expected list.
        tempProductList.addAll(actualProductPriceList);
        Collections.sort(tempProductList);//collections is a class/collection is a method
        System.out.println(tempProductList);
        assertThat(actualProductPriceList, is(equalTo(tempProductList)));
    }


}
