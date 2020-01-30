package com.cttest.pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage<BasketPage> {

    @Visible
    @FindBy(css="a.label:nth-child(1)")
    WebElement firstBasketItemName;

    public String getFirstBasketItemName() {
        return firstBasketItemName.getText();
    }

    private static String URL = "http://172.18.200.76/index.php?controller=cart&action=show";

    public void navigate() {
        get(URL);
    }
}
