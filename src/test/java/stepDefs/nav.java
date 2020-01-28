package stepDefs;

import io.cucumber.java.en.Given;
import pageModels.Page;

public class nav {

    @Given("the user is on the (.+)page")
    public void theUserIsOnThePage(String pageString) {
        Page page = Page.parse(pageString);
        page.navigate();
    }
}
