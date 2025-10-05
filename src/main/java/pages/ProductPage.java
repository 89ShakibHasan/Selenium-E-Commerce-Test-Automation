package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ProductPage extends BasePage{

    private final By productAddedMessage=By.xpath("//div[@id='jm']//div[@class='cnt']");
    private final By addToCartButton = By.id("add-to-cart");
    private final By productQuantityButton = By.xpath("//div[5]//form[1]//button[2]");
    private final By viewCartButton = By.xpath("//a[text()='View Cart and Checkout']");
    private final By cookiesCancelButton=By.cssSelector(".cls");


    public void addToCart(){
        click(addToCartButton);
    }
    public void chooseQuantity(){
        click(productQuantityButton);
        }
    public CartPage goToCartAndCheckout(){
        elementVisibilityExplicitWait(productAddedMessage,5);
        click(viewCartButton);
        return new CartPage();
    }
}
