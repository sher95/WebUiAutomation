package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.DashboardPage;
import utils.DriverManager;
import java.io.IOException;
import java.time.Duration;

public class LoginStep {
    private final WebDriver driver = DriverManager.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private final DashboardPage dashboardPage = new DashboardPage(driver);
    private WebDriverWait wait;

    @Given("the user is on login page")
    public void iAmOnTheHomePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("the user enters valid credentials")
    public void iEnterUsernameAndPassword() throws IOException {
        homePage.enterUsername(wait);
        homePage.enterPassword(wait);
    }

    @When("click Submit")
    public void iClickTheLoginButton() {
        homePage.clickLoginButton(wait);
    }

    @Then("the user should be logged in successfully")
    public void iShouldSeeTheDashboard() {
        // Add assertion for dashboard verification
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(wait));
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
