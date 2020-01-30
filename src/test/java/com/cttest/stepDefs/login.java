package com.cttest.stepDefs;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class login {
    PageAPI pageAPI;

    public login(PageAPI pageAPI) {
        this.pageAPI = pageAPI;
    }

    @Step
    @Given("the (.+) user is logged in")
    public void theUserIsLoggedIn(String userType) {
        pageAPI.homePage = pageAPI.homePage.open();
    }
}
