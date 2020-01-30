package com.cttest.stepDefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.junit.Assert;

public class Basket {

    PageAPI pageAPI;
    String productPageItemName;
    String basketPageItemName;

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
        productPageItemName = pageAPI.productPage.getItemName();
        pageAPI.modalProductPage = pageAPI.productPage.addToBasket();
    }

    @Step
    @Then("(if I )navigate to the basket page")
    public void navigateToTheBasketPage() {
        pageAPI.basketPage = pageAPI.modalProductPage.clickGoToBasket();
    }

    @Step
    @Then("the item should be in the basket")
    public void theItemShouldBeInTheBasket() {
        basketPageItemName = pageAPI.basketPage.getFirstBasketItemName();
        Assert.assertEquals(productPageItemName.toLowerCase(), basketPageItemName.toLowerCase());
    }

}