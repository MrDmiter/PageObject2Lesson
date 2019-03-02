package com.aqacourses.project;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ColorsEnum;

import java.util.List;

public class SummerDresses extends BaseClass {

    //Web Elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement headingCounter;

    @FindBy(xpath = "//*[@id='layered_id_attribute_group_8']")
    private WebElement whiteColorIcon;
    @FindBy(xpath = "//a[contains(text(),'Blue')]")
    private WebElement blueColorIcon;
    @FindBy(xpath = "//a[contains(text(),'Black')]")
    private WebElement blackColorIcon;
    @FindBy(xpath = "//a[contains(text(),'Orange')]")
    private WebElement orangeColorIcon;
    @FindBy(xpath = "//a[contains(text(),'Green')]")
    private WebElement greenColorIcon;
    @FindBy(xpath = "//a[contains(text(),'Yellow')]")
    private WebElement yellowColorIcon;

    @FindBy(xpath = "//div[@id='enabled_filters']")
    private WebElement enabledFilters;

    /**
     * Constructor
     *
     * @param testClass
     */
    public SummerDresses(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Compare amount of the products shown by the product counter and amount of the products displayed on the page
     */

    //Почему я могу взвать findElements() через heading counter, как то странно получается...как будет правильно в данном случае?
    public void verifyAmountOfProductsOnPage() {
        int amountShownByCounter = Integer.parseInt(headingCounter.getText().replaceAll("\\D", ""));
        //Get list of the available products on the page
        List<WebElement> list =
                headingCounter.findElements(By.xpath("//span[@class='available-now']"));
        System.out.println("amountShownByCounter=" + amountShownByCounter + " displayedProductsOnPage=" + list.size());
        //Compare counter value with amount of the displayed products
        Assert.assertEquals(amountShownByCounter, list.size());
    }

    /**
     * Click on the filter by color
     */

    public void clickOnTheColorFilter(ColorsEnum colors) {
        switch (colors) {
            case WHITE:
                whiteColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            case BLUE:
                blueColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            case YELLOW:
                yellowColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            case BLACK:
                blackColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            case GREEN:
                greenColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            case ORANGE:
                orangeColorIcon.click();
                testClass.waitElementToBeClickable(enabledFilters);
                break;
            default:
                System.out.println("Such color doesn`t exist");
                break;
        }

        //
    }
}
