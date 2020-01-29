package pageModels;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage<HomePage> implements Page {
    public static final String URL = "http://";

    @Visible
    @FindBy(css="#q")
    WebElement searchBox;

    @Visible
    @FindBy(css="article:first-child > div > a")
    WebElement firstProduct;

    public void clickFirstProduct() {
        firstProduct.click();
    }

    @Override
    public void navigate() {
        get(URL);
    }
}
