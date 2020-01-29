package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import pageModels.BasketPage;
import pageModels.HomePage;
import pageModels.Page;
import pageModels.ProductPage;

public class Basket {

    HomePage homePage;
    ProductPage productPage;
    BasketPage basketPage;

    public Basket() {
        this.homePage = (HomePage)Page.parse("home");
        this.productPage = (ProductPage)Page.parse("product");
        this.basketPage = (BasketPage)Page.parse("basket");
    }

    @When("(I )click on an item")
    public void iClickOnAnItem() {
        homePage.clickFirstProduct();
    }

    @When("(I )add (.+) to my basket")
    public void iAddItToMyBasket() {
        productPage.addToBasket();
    }

    @Then("(if I )navigate to the basket page")
    public void navigateToTheBasketPage() {
        basketPage.navigate();
    }

    @Then("the item should be in the basket")
    public void theItemShouldBeInTheBasket() {
        //check basket items length
    }

}
