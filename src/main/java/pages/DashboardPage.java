package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    private WebElement dashboardHeading;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(dashboardHeading));
        return dashboardHeading.isDisplayed();
    }
}
