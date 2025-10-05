package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test(priority = 1)
    public void testProductInCart(){
       login();
        var cartPage=homePage.gotoCart();
        Assert.assertEquals(cartPage.getProductText(),"Tempo Zamalek Home Match Jersey 22/23 - Fan Edition");
    }
    @Test(priority = 2)
    public void testDeletingProductFromCart(){
        login();
        var cartPage=homePage.gotoCart();
        cartPage.removeProductFromCart();
        Assert.assertEquals(cartPage.getEmptyCartText(),"Your cart is empty!");
    }
}
