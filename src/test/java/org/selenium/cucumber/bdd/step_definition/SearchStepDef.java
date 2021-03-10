package org.selenium.cucumber.bdd.step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.selenium.cucumber.bdd.pageobject.HomePage;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class SearchStepDef {
    String searchTerm = "nike";
    private HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.isOnHomePage();
        assertThat(actual, is(endsWith("co.uk/")));
    }

    @When("^I search for product nike$")
    public void i_search_for_product_nike() {
        homePage.doSearch("nike");
    }

    @Then("^I should see respective products$")
    public void i_should_see_respective_products() {
        String actual = resultsPage.getProductTitle();
        assertThat(actual, containsString(searchTerm));
        String urlActual = resultsPage.getCurrentUrl();
        assertThat(urlActual, endsWith(searchTerm));


    }



}