package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Selector xác thực theo login_page_source.html
    private final By accountInput = By.id("account");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    // Error banner: giả định xuất hiện trong div.bg-white, cần xác nhận lại nếu có class cụ thể
    private final By errorBanner = By.xpath("//div[contains(@class,'bg-white')]//*[contains(text(),'Account') or contains(text(),'Password') or contains(text(),'incorrect')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterAccount(String account) {
        type(accountInput, account);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getAccountValue() {
        return findElement(accountInput).getAttribute("value");
    }

    public String getPasswordValue() {
        return findElement(passwordInput).getAttribute("value");
    }

    public void clearAccount() {
        findElement(accountInput).clear();
    }

    public void clearPassword() {
        findElement(passwordInput).clear();
    }

    public boolean isLoginFormDisplayed() {
        return isElementDisplayed(accountInput) && isElementDisplayed(passwordInput) && isElementDisplayed(loginButton);
    }

    public boolean isAccountInputFocused() {
        return driver.switchTo().activeElement().equals(findElement(accountInput));
    }

    public boolean isErrorBannerDisplayed() {
        return isElementDisplayed(errorBanner);
    }

    public String getErrorMessage() {
        return getText(errorBanner);
    }
} 