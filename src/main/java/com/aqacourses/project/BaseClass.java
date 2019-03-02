package com.aqacourses.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {

    //Web Elements

    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement stickySignInBtn;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    private WebElement dressesTab;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][contains(text(),'Summer Dresses')]")
    private WebElement summerDressesSubTab;

    //Instance of BaseTest
    protected BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public BaseClass(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click on the sign in button on the home page
     *
     * @return
     */
    public SignInPage signInClick() {
        stickySignInBtn.click();
        return new SignInPage(testClass);
    }

    /**
     * Hover over "Dresses" tab in main top menu
     */
    public void hoverOverDressesItem() {
        Actions builder = new Actions(testClass.getDriver());
        builder.moveToElement(dressesTab).build().perform();
    }

    /**
     * Click on the "Summer Dresses" link
     *
     * @return
     */
    public SummerDresses clickOnSummerDressesItem() {
        testClass.waitElementToBeClickable(summerDressesSubTab);
        summerDressesSubTab.click();
        return new SummerDresses(testClass);
    }
}
