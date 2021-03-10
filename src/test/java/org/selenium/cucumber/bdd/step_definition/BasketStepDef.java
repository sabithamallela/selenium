package org.selenium.cucumber.bdd.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.selenium.cucumber.bdd.pageobject.BasketPage;
import org.selenium.cucumber.bdd.pageobject.ProductDecPage;
import org.selenium.cucumber.bdd.pageobject.ResultsPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BasketStepDef {
    private ProductDecPage productDecPage=new ProductDecPage();
    private ResultsPage resultsPage=new ResultsPage();
    private BasketPage basketPage= new BasketPage();
    String selectProductName;
    @And("^I add any product to basket$")
    public void i_add_any_product_to_basket(){
     selectProductName = resultsPage.selectAnyProduct(); // Expected
       productDecPage.addProductToTrolley();
    }

    @Then("^I should see product added to basket$")
    public void i_should_see_product_added_to_basket() {
productDecPage.goToTrolley();
List<String> itemsInTrolley = basketPage.getAllItemsInBasket();//actual results
        System.out.println("itemsInTrolley = " + itemsInTrolley);
        System.out.println("selectProductName = " + selectProductName);
        assertThat(itemsInTrolley, hasItem(selectProductName));
    }
}


