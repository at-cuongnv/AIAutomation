package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public abstract class BasePage {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    protected final WebDriver driver;
    protected final WaitHelper wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    protected WebElement findElement(By locator) {
        return wait.waitForElementVisible(locator);
    }

    protected void click(By locator) {
        wait.waitForElementClickable(locator).click();
        logger.debug("Clicked element: {}", locator);
    }

    protected void type(By locator, String text) {
        WebElement element = wait.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
        logger.debug("Typed '{}' into {}", text, locator);
    }

    protected String getText(By locator) {
        return wait.waitForElementVisible(locator).getText().trim();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return wait.waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForUrlContains(String urlFraction) {
        wait.waitForUrlContains(urlFraction);
        logger.debug("URL contains: {}", urlFraction);
    }
} 