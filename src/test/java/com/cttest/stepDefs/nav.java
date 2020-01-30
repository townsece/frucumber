package com.cttest.stepDefs;

import com.cttest.pageModels.HomePage;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class nav {
    PageAPI pageAPI;

    public nav (PageAPI pageAPI) {
        this.pageAPI = pageAPI;
    }

    @Step
    @Given("the user is on the (.+)page")
    public void theUserIsOnThePage(String pageString) {
        switch(pageString) {
            case "home":
                pageAPI.homePage = new HomePage().open();
        }
    }
}
