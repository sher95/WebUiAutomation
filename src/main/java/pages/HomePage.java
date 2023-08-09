package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage extends BasePage{
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
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

    public void clickLoginButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
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
