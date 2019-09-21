package my.project;

import my.project.configs.SrpSearchRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static my.project.Config.CHROMEDRIVER_LOCATION;

public class SrpMatcher {

    public void match(SrpSearchRequest request) {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);

        WebDriver driver = new ChromeDriver();

        final Set<String> pdpUrls = findPdpUrls(driver, request);

        final Set<String> matchedPdpUrls = findMatches(driver, request, pdpUrls);

        reportResults(matchedPdpUrls);
    }

    private void reportResults(Set<String> matchedPdpUrls) {
        System.out.println(matchedPdpUrls);
    }

    private Set<String> findMatches(WebDriver driver, SrpSearchRequest request, Set<String> pdpUrls) {
        final Set<String> matchedPdpUrls = new HashSet<String>();
        for (String pdpUrl : pdpUrls) {
            driver.get(pdpUrl);
            final String currentUrl = driver.getCurrentUrl();
            if (request.match(driver)) {
                matchedPdpUrls.add(currentUrl);
            }
        }
        return matchedPdpUrls;
    }


    private Set<String> findPdpUrls(WebDriver driver, SrpSearchRequest request) {
        driver.get(request.getSrpUrl());

        final List<WebElement> tiles = driver.findElements(By.cssSelector(request.getPDPLinkElementSelector()));
        Set<String> pdpUrls = new HashSet<String>(tiles.size());
        for (WebElement tile : tiles) {
            final String pdpUrl = tile.getAttribute("href");
            pdpUrls.add(pdpUrl);
        }
        return pdpUrls;
    }
}
