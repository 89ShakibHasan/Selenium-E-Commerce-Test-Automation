package E2E;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingAProductE2E extends BaseTest {


    @Test(priority = 1)
    public void testEmptyAddressCheckOut() throws InterruptedException {
        login();
        String searchWord="zamalek tempo";
        var searchResultsPage=homePage.search(searchWord);
        searchResultsPage.cancelCookiesMessage();
        var productPage=searchResultsPage.choosingTheProductToBuy("Tempo Zamalek Home Match Jersey 22/23 - Fan Edition");
        productPage.addToCart();
        productPage.chooseQuantity();
        var cartPage= productPage.goToCartAndCheckout();
        var checkOutPage=cartPage.goToCheckoutPage();
        checkOutPage.chooseCity("Port Said");
        checkOutPage.chooseRegion("Port-Fouad");
        checkOutPage.pressSaveAndContinue();
        Assert.assertEquals(checkOutPage.getEmptyAddressText(),"Required field");
    }

    @Test(priority = 2)
    public void testEmptyCityCheckOut() throws InterruptedException {
        login();
        var cartPage=homePage.gotoCart();
        var checkOutPage=cartPage.goToCheckoutPage();
        checkOutPage.enterAddress("dgwrhkbwnbmlsmblwmegkqe,ngb");
        checkOutPage.chooseCity("Port Said");
        checkOutPage.pressSaveAndContinue();
        Assert.assertEquals(checkOutPage.getEmptyAddressText(),"Required field");
    }

    @Test(priority = 3)
    public void testSuccessfulCheckout() throws InterruptedException {
        login();
        var cartPage=homePage.gotoCart();
        var checkOutPage=cartPage.goToCheckoutPage();
        checkOutPage.enterAddress("dgwrhkbwnbmlsmblwmegkqe,ngb");
        checkOutPage.chooseCity("Port Said");
        checkOutPage.chooseRegion("Port-Fouad");
        checkOutPage.pressSaveAndContinue();
        checkOutPage.chooseDoorDeliveryRadioButton();
        checkOutPage.pressProceedToNextStepButton();
    }


}
