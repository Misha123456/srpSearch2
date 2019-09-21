package my.project.configs;

import org.openqa.selenium.WebDriver;

public interface SrpSearchRequest {

    String getSrpUrl();

    String getPDPLinkElementSelector();

    boolean match(WebDriver currentPDP);

}
