package pageModels;

public interface Page {
    public static final Page homePage = new HomePage();
    public static final Page productPage = new ProductPage();
    public static final Page basketPage = new BasketPage();

    static Page parse(String pageName) {
        Page page;
        switch(pageName) {
            default:
            case "login":
            case "basket":
                page = basketPage;
                break;
            case "product":
                page = productPage;
                break;
            case "checkout":
            case "home":
            case "home ":
                page = homePage;
                break;
        }
        return page;
    }

    void navigate();
}
