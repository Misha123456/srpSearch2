package my.project.configs;

import my.project.wildberries.WildBerriesMatcher;
import org.openqa.selenium.WebDriver;

public class WildBerriesRequest implements SrpSearchRequest {

    private String srpUrl;
    private String pdpLineElementSelector;
    private WildBerriesMatcher matcher = new WildBerriesMatcher();

    public WildBerriesRequest(String srpUrl, String pdpLineElementSelector) {
        this.srpUrl = srpUrl;
        this.pdpLineElementSelector = pdpLineElementSelector;
    }

    public String getSrpUrl() {
        return this.srpUrl;
    }

    public String getPDPLinkElementSelector() {
        return this.pdpLineElementSelector;
    }

    public boolean match(WebDriver currentPDP) {
        return matcher.match(currentPDP);
    }
}
