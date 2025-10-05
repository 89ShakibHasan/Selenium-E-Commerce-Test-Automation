package savedItems;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTests extends BaseTest {

    @Test(priority = 0)
    public void testingAddingItemsToWishList(){
        login();
        String searchWord="harry potter books";
        var searchResultsPage=homePage.search(searchWord);
        searchResultsPage.addToWishList("Harry Potter And The Chamber Of Secrets");

    }
    @Test(priority = 1)
    public void testingRemovingItemsFromWishList(){
        login();
        var savedItemPage=homePage.goToSavedItemsPage();
        savedItemPage.removeSavedItem();
        Assert.assertEquals(savedItemPage.getAssertionText(),"You haven’t saved an item yet!");
    }
}
