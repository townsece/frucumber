package pageModels;

public interface Page {
    public static final Page homePage = new HomePage();

    static Page parse(String pageName) {
        Page page;
        switch(pageName) {
            default:
            case "login":
            case "basket":
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
