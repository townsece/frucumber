package com.cttest.stepDefs;

import io.cucumber.java.en.Given;

public class login {
    PageAPI pageAPI;

    public login(PageAPI pageAPI) {
        this.pageAPI = pageAPI;
    }
    @Given("the (.+) user is logged in")
    public void theUserIsLoggedIn(String userType) {
        pageAPI.homePage = pageAPI.homePage.open();
    }
}
