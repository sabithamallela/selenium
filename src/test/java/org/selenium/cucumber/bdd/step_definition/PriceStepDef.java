package org.selenium.cucumber.bdd.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PriceStepDef {
    ResultsPage resultsPage=new ResultsPage();
    double min,max;

    @And("^I select any price range$")
    public void iSelectAnyPriceRange() {
       List<String>selectedRange= resultsPage.selectPriceRange();

        min = Double.parseDouble(selectedRange.get(0));//expected
        max = Double.parseDouble(selectedRange.get(1));//expected
    }

    @Then("^I should view products within the range$")
    public void iShouldViewProductsWithinTheRange() {//actual
       List<Double> actual= resultsPage.getPrices();
        assertThat(actual, both(everyItem(greaterThanOrEqualTo(min))).and(everyItem(lessThanOrEqualTo(max))));
    }
}
