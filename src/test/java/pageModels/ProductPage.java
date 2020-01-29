package pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage<ProductPage> implements Page {
    private static final String URL = "http://172.18.200.76/index.php?id_product=1&id_product_attribute=1&rewrite=faded-short-sleeves-tshirt&controller=product#/1-size-s/13-color-orange";

    @Visible
    @FindBy(css=".add")
    WebElement addToBasket;

    public void addToBasket() {
        addToBasket.click();
    }

    @Override
    public void navigate() {
        get(URL);
    }
}
