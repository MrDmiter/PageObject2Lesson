package com.aqacourses.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    //WebDriver and WebDriverWait instances
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Get driver
     *
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait element to be clickable
     *
     * @param webElement
     */
    public void waitElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Open site
     *
     * @return
     */
    public HomePage openSite() {
        driver.get("http://automationpractice.com/");
        return new HomePage(this);
    }

    /**
     * Close site
     */
    public void closeSite() {
        driver.quit();
    }
}
