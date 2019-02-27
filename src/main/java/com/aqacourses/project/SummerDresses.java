package com.aqacourses.project;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummerDresses extends BaseClass {

    //Web Elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement headingCounter;

    @FindBy(xpath = "//*[@id=\"layered_id_attribute_group_8\"]")
    private WebElement whiteColorIcon;

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
        //Counter
        int displayedProductsOnPage = 0;

        for (WebElement webElement : list) {
            displayedProductsOnPage++;
        }
        System.out.println("amountShownByCounter=" + amountShownByCounter + " displayedProductsOnPage=" + displayedProductsOnPage);
        Assert.assertEquals(amountShownByCounter, displayedProductsOnPage);
    }

    /**
     * Click on the filter by color
     */
    public void clickOnTheColorFilter() {
        whiteColorIcon.click();
        testClass.waitElementToBeClickable(enabledFilters);
    }
}
