package com.cttest.pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage<ProductPage> {
    private static final String URL = "http://172.18.200.76/index.php?id_product=1&id_product_attribute=1&rewrite=faded-short-sleeves-tshirt&controller=product#/1-size-s/13-color-orange";

    @Visible
    @FindBy(css="button.btn-primary")
    WebElement addToBasket;

    @Visible
    @FindBy(css="#_desktop_cart")
    WebElement basketButton;

    @Visible
    @FindBy(css=".h1")
    WebElement itemName;


    public ModalProductPage addToBasket() {
        addToBasket.click();
        return (ModalProductPage)new ModalProductPage().get();
    }

    public BasketPage clickBasketButton() {
        basketButton.click();
        return new BasketPage().get();
    }

    public String getItemName() {
        return itemName.getText();
    }
}
