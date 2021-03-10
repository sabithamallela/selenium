package org.selenium.cucumber.bdd.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ReviewStepDef {
    private ResultsPage resultsPage=new ResultsPage();
    Double expected;
    @And("^I select any rating$")
    public void iSelectAnyRating() {
      expected=  resultsPage.selectAnyRating();

    }

    @Then("^I should see selected rating products$")
    public void iShouldSeeSelectedRatingProducts() {
        List<Double> actualRatingList=resultsPage.getAllProductsRating();
        assertThat(actualRatingList,everyItem(greaterThanOrEqualTo(expected)));
    }
}

