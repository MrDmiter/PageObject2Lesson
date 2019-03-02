package tests;

import com.aqacourses.project.*;
import org.junit.Test;
import util.ColorsEnum;

public class PageObject2Test extends BaseTest {

    /**
     * To verify correctness of the product counter functionality
     */
    @Test
    public void testPageObject2Test() {
        //Open the site
        HomePage homePage = openSite();

        //Proceed to the Sign in page
        SignInPage signInPage = homePage.signInClick();

        //Sign in to My Account
        MyAccountPage myAccountPage = signInPage.signIn();

        //Hover over Dresses category
        myAccountPage.hoverOverDressesItem();

        //Click on the Summer Dresses product type
        SummerDresses summerDresses = myAccountPage.clickOnSummerDressesItem();

        //Verify amount of the products on the page shown by default
        summerDresses.verifyAmountOfProductsOnPage();

        //Choose white in the filter
        summerDresses.clickOnTheColorFilter(ColorsEnum.WHITE);

        //Verify amount of the products on the page after clicking on the filter
        summerDresses.verifyAmountOfProductsOnPage();

        //Close site
        closeSite();
    }
}
