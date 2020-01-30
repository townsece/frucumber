package com.cttest.stepDefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

public class Basket {

    PageAPI pageAPI;

    public Basket(PageAPI pageAPI) {
        this.pageAPI = pageAPI;
    }

    @Step
    @When("(I )click on an item")
    public void iClickOnAnItem() {
        pageAPI.productPage = pageAPI.homePage.clickFirstProduct();
    }

    @Step
    @When("(I )add (.+) to my basket")
    public void iAddItToMyBasket() {
        pageAPI.productPage.addToBasket();
    }

    @Step
    @Then("(if I )navigate to the basket page")
    public void navigateToTheBasketPage() {
        pageAPI.basketPage = pageAPI.productPage.clickBasketButton();
    }

    @Step
    @Then("the item should be in the basket")
    public void theItemShouldBeInTheBasket() {
        //check basket items length
    }

}
