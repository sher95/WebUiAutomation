package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;
import java.time.Duration;

public class DashboardStep {
    private final WebDriver driver = DriverManager.getDriver();
    private final DashboardPage dashboardPage = new DashboardPage(driver);
    private WebDriverWait wait;

    @Given("the user is logged in and on the dashboard")
    public void theUserisLoggedinAndOnTheDashboard() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(wait));
    }
    @Then("the \"Time at Work\" section should be displayed")
    public void theTimeAtWorkSectionShouldBeDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isTimeAtWorkSectionDisplayed(wait));
    }

    @Then("the \"My Actions\" section should be displayed")
    public void myActionsSectionShouldBeDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isMyActionsSectionDisplayed(wait));
    }

    @Then("the \"Quick Launch\" section should be displayed")
    public void theQuickLaunchSectionShouldBeDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isQuickLaunchSectionDisplayed(wait));
    }

    @Then("the \"Buzz Latest Posts\" section should be displayed")
    public void theBuzzLatestPostsSectionShouldBeDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isBuzzLatestPostsSectionDisplayed(wait));
    }

    @Then("the \"Employees on Leave Today\" section should be displayed")
    public void theEmployeesonLeaveTodaySectionShouldBeDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(dashboardPage.isEmployeesonLeaveTodaySectionDisplayed(wait));
    }
}
