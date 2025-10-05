package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private final By allItems = By.xpath("//h3[@class='name']");
    private final By addToCartButton2 = By.id("add-to-cart");
    private final By addedToCartAssertion = By.cssSelector(".-pam.-f1");
    private final By addedToWishListAssertion = By.cssSelector(".cnt");
    private final By cartButton = By.id("ci");
    private final By saveItemButton = By.id("wishlist");
    private final By cookiesCancelButton=By.cssSelector(".cls");

    public Boolean assertSearchResults(String searchWord) {
        int j = 0;
        Boolean x = false;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(searchWord.substring(1))) {
                j++;
                if (j == 5) {
                    x = true;
                    break;
                }
            }
        }
        return x;
    }
    public void addToCart(String product) {

        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(product)) {
                products.get(i).click();
                click(addToCartButton2);
                elementVisibilityExplicitWait(addedToCartAssertion, 10);
                driver.navigate().back();
                break;
            }
        }
    }
    public void addToWishList(String product) {
        String productToSave = product;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(productToSave)) {
                products.get(i).click();
                click(saveItemButton);
                elementVisibilityExplicitWait(addedToWishListAssertion, 10);
                driver.navigate().back();
                break;
            }
        }
    }
    public CartPage gotoCart() {
        click(cartButton);
        return new CartPage();
    }
    public ProductPage choosingTheProductToBuy(String product) {
        String productToBuy = product;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(productToBuy)) {
                products.get(i).click();
                break;
            }
        }
        return new ProductPage();
    }
    public void cancelCookiesMessage(){
        elementVisibilityExplicitWait(cookiesCancelButton,8);
        click(cookiesCancelButton);
    }


}

