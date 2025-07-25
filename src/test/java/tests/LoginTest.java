package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get("http://localhost:3000/login");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "TC01 - Screen initializes correctly")
    public void testScreenInitializesCorrectly() {
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form should be displayed");
        Assert.assertTrue(loginPage.isAccountInputFocused(), "Account input should be focused");
        Assert.assertFalse(loginPage.isErrorBannerDisplayed(), "No error message should be shown");
    }

    @Test(description = "TC02 - Account input max length 10")
    public void testAccountInputMaxLength() {
        String longAccount = "abcdefghijk"; // 11 chars
        loginPage.enterAccount(longAccount);
        String actual = loginPage.getAccountValue();
        Assert.assertEquals(actual.length(), 10, "Only 10 characters should be accepted in Account field");
    }

    @Test(description = "TC03 - Password input max length 10")
    public void testPasswordInputMaxLength() {
        String longPassword = "abcdefghijk"; // 11 chars
        loginPage.enterPassword(longPassword);
        String actual = loginPage.getPasswordValue();
        Assert.assertEquals(actual.length(), 10, "Only 10 characters should be accepted in Password field");
    }

    @Test(description = "TC04 - Validation missing Account")
    public void testValidationMissingAccount() {
        loginPage.clearAccount();
        loginPage.enterPassword("anyvalue");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorBannerDisplayed(), "Error banner should appear");
        Assert.assertEquals(loginPage.getErrorMessage(), "Account and password are required");
    }

    @Test(description = "TC05 - Validation missing Password")
    public void testValidationMissingPassword() {
        loginPage.enterAccount("anyvalue");
        loginPage.clearPassword();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorBannerDisplayed(), "Error banner should appear");
        Assert.assertEquals(loginPage.getErrorMessage(), "Account and password are required");
    }

    @Test(description = "TC06 - Successful login as Admin")
    public void testSuccessfulLoginAsAdmin() {
        loginPage.enterAccount("admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        loginPage.waitForUrlContains("/admin/permission");
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/permission"), "Should navigate to /admin/permission");
    }

    @Test(description = "TC07 - Successful login as Staff")
    public void testSuccessfulLoginAsStaff() {
        loginPage.enterAccount("staff");
        loginPage.enterPassword("staff123");
        loginPage.clickLogin();
        loginPage.waitForUrlContains("/resource");
        Assert.assertTrue(driver.getCurrentUrl().contains("/resource"), "Should navigate to /resource");
    }

    @Test(description = "TC08 - Invalid credentials")
    public void testInvalidCredentials() {
        loginPage.enterAccount("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorBannerDisplayed(), "Error banner should show backend message");
        Assert.assertEquals(loginPage.getErrorMessage(), "Account not found or password incorrect.");
        Assert.assertEquals(loginPage.getPasswordValue(), "", "Password field should be cleared");
    }
} 