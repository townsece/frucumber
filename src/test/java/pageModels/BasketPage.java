package pageModels;

import com.frameworkium.core.ui.pages.BasePage;

public class BasketPage extends BasePage<BasketPage> implements Page {

    private static String URL = "";

    @Override
    public void navigate() {
        get(URL);
    }
}
