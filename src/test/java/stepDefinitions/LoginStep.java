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
    public void iAmOnTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("the user enters valid credentials")
    public void iEnterValidCredentials() throws IOException {
        homePage.enterUsername(wait);
        homePage.enterPassword(wait);
    }

    @When("click Submit")
    public void iClickTheLoginButton() {
        homePage.clickLoginButton(wait);
    }

    @Then("the user should be logged in successfully")
    public void iShouldSeeTheDashboard() {
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(wait));
    }

    @When("the user enters incorrect password")
    public void iEnterIncorrectPassword() throws IOException {
        homePage.enterUsername(wait);
        homePage.enterIncorrectPassword(wait);
    }

    @When("enters empty username")
    public void iEnterEmptyUsername() throws IOException {
        homePage.enterEmptyUsername(wait);
        homePage.enterPassword(wait);
    }

    @When("enters empty password")
    public void iEnterEmptyPassword() throws IOException {
        homePage.enterUsername(wait);
        homePage.enterEmptyPassword(wait);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() throws InterruptedException {
        String actualErrorMessage = homePage.getErrorMessageText(wait);
        String expectedErrorMessage = "Invalid credentials"; // Replace with your expected error message
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Then("an password required message should be displayed")
    public void anPasswordRequiredMessageShouldBeDisplayed() {
        String expectedErrorMessage = "Required"; // Replace with your expected error message
        String actualErrorMessage = homePage.getErrorRequiredPass(wait);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Then("an user required message should be displayed")
    public void anUserRequiredMessageShouldBeDisplayed() {
        String expectedErrorMessage = "Required"; // Replace with your expected error message
        String actualErrorMessage = homePage.getErrorRequiredUser(wait);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Then("the username input field should be displayed")
    public void theUsernameInputFieldShouldBeDisplayed() {
        Assert.assertTrue(homePage.isUsernameInputDisplayed(wait));
    }

    @Then("the password input field should be displayed")
    public void thePasswordInputFieldShouldBeDisplayed() {
        Assert.assertTrue(homePage.isPasswordInputDisplayed(wait));
    }

    @Then("the login button should be displayed")
    public void theLoginButtonShouldBeDisplayed() {
        Assert.assertTrue(homePage.isLoginButtonDisplayed(wait));
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
