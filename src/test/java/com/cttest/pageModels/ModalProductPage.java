package com.cttest.pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalProductPage extends ProductPage {
    @Visible
    @FindBy(css=".btn-secondary")
    WebElement continueShopping;

    @Visible
    @FindBy(css="a.btn")
    WebElement goToBasket;

    public ProductPage continueShopping() {
        continueShopping.click();
        return new ProductPage();
    }

    public BasketPage clickGoToBasket() {
        goToBasket.click();
        return new BasketPage().get();
    }
}
