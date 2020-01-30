package com.cttest.pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage<BasketPage> {

    @Visible
    @FindBy(css="a.label:nth-child(1)")
    WebElement firstBasketItemName;

    @Visible
    @FindBy(css=".remove-from-cart")
    WebElement deleteFirstBasketItem;

    @FindBy(css=".no-items")
    WebElement noItems;

    public String getFirstBasketItemName() {
        return firstBasketItemName.getText();
    }

    public void clickDeleteFirstBasketItem() {
        deleteFirstBasketItem.click();
    }

    public WebElement getNoItems() {
        return noItems;
    }

    private static String URL = "http://172.18.200.76/index.php?controller=cart&action=show";

    public void navigate() {
        get(URL);
    }
}
