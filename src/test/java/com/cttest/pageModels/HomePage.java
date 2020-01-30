package com.cttest.pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage<HomePage> {
    public static final String URL = "http://172.18.200.76/index.php";

    @FindBy(css="#q")
    WebElement searchBox;

    @Visible
    @FindBy(css="article:first-child > div > a")
    WebElement firstProduct;

    public ProductPage clickFirstProduct() {
        firstProduct.click();
        return new ProductPage().get();
    }

    public HomePage open() { return new HomePage().get(URL); }
}
