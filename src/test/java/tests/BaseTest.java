package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {
        logger.atLevel(Level.OFF);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshot(ITestResult result) {
        if (driver == null) return;

        // Take screenshot and save under screenshot/ directory with method name and status
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String status = result.isSuccess() ? "PASS" : "FAIL";
        String fileName = String.format("%s_%s_%s.png", 
            result.getMethod().getMethodName(), 
            status,
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")));

        Path destPath = Paths.get("screenshot", fileName);
        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(src.toPath(), destPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            logger.info("Screenshot saved: {}", destPath);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 