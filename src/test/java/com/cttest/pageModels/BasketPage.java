package com.cttest.pageModels;

import com.frameworkium.core.ui.pages.BasePage;

public class BasketPage extends BasePage<BasketPage> {

    private static String URL = "";

    public void navigate() {
        get(URL);
    }
}
