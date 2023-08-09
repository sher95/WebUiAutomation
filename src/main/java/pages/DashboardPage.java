package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    private WebElement dashboardHeading;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div/p")
    private WebElement timeAtWorkSection;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/p")
    private WebElement myActionsSection;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[1]/div/p")
    private WebElement quickLounchSection;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div/p")
    private WebElement buzzLatestPostsSection;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[1]/div/p")
    private WebElement employeesonLeaveTodaySection;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(dashboardHeading));
        return dashboardHeading.isDisplayed();
    }

    public boolean isTimeAtWorkSectionDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(timeAtWorkSection));
        return timeAtWorkSection.isDisplayed();
    }

    public boolean isMyActionsSectionDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(myActionsSection));
        return myActionsSection.isDisplayed();
    }

    public boolean isQuickLaunchSectionDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(quickLounchSection));
        return myActionsSection.isDisplayed();
    }

    public boolean isBuzzLatestPostsSectionDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(buzzLatestPostsSection));
        return myActionsSection.isDisplayed();
    }

    public boolean isEmployeesonLeaveTodaySectionDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(employeesonLeaveTodaySection));
        return myActionsSection.isDisplayed();
    }
}
