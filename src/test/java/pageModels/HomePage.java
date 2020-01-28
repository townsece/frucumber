package pageModels;

import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage<HomePage> implements Page {
    public static final String URL = "http://";
    @FindBy(css="#q")
    WebElement searchBox;

    @Override
    public void navigate() {
        get(URL);
    }
}
