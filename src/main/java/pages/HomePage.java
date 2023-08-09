package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage extends BasePage {
    @SuppressWarnings("unused")
    @FindBy(name = "username")
    private WebElement usernameInput;

    @SuppressWarnings("unused")
    @FindBy(name = "password")
    private WebElement passwordInput;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement loginButton;

    @SuppressWarnings("unused")
    @FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    private WebElement errorMessage;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
    private WebElement errorRequiredUser;

    @SuppressWarnings("unused")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")
    private WebElement errorRequiredPass;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessageText(WebDriverWait wait) throws InterruptedException {
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getErrorRequiredPass(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(errorRequiredPass));
        return errorRequiredPass.getText();
    }
    public String getErrorRequiredUser(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(errorRequiredUser));
        return errorRequiredUser.getText();
    }

    public void enterUsername(WebDriverWait wait) throws IOException {
        Properties properties = loadProperties();
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(properties.getProperty("username"));
    }

    public void enterPassword(WebDriverWait wait) throws IOException {
        Properties properties = loadProperties();
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(properties.getProperty("password"));
    }

    public void enterIncorrectPassword(WebDriverWait wait) throws IOException {
        Properties properties = loadProperties();
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(properties.getProperty("incorrectPassword"));
    }

    public void enterEmptyUsername(WebDriverWait wait) throws IOException {
        Properties properties = loadProperties();
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(properties.getProperty("emptyUsername"));
    }

    public void enterEmptyPassword(WebDriverWait wait) throws IOException {
        Properties properties = loadProperties();
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(properties.getProperty("emptyPassword"));
    }

    public void clickLoginButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public boolean isUsernameInputDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        return usernameInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        return passwordInput.isDisplayed();
    }

    public boolean isLoginButtonDisplayed(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        String credentialsPath = "/config.properties";
        try (InputStream input = getClass().getResourceAsStream(credentialsPath)) {
            properties.load(input);
        }
        return properties;
    }
}
