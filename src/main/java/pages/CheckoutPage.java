package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    private final By addressField=By.id("ShippingAddressForm_address1");
    private final By stateField=By.id("ShippingAddressForm_fk_customer_address_region");
    private final By cityField=By.id("ShippingAddressForm_fk_customer_address_city");
    private final By saveAndContinueButton=By.id("osh-opc-btn-save-address-shipping");
    private final By doorDeliveryRadioButton=By.cssSelector("label[for='UniversalShippingMatrix']");
    private final By proceedToNextStepButton=By.id("osh-opc-btn-save");
    private final By emptyAddressText=By.xpath("//div[text()='Required field']");

    public void enterAddress(String address){
        sendKeys(addressField,address);
    }
    public void chooseCity(String city) throws InterruptedException {
        Select dropDown= new Select(find(stateField));
        dropDown.selectByVisibleText(city);
        Thread.sleep(1000);
    }
    public void chooseRegion(String region){
        Select dropDown= new Select(find(cityField));
        dropDown.selectByVisibleText(region);
    }
    public String getEmptyAddressText(){
        return getText(emptyAddressText);
    }
    public void pressSaveAndContinue(){
        click(saveAndContinueButton);
    }
    public void chooseDoorDeliveryRadioButton(){
        click(doorDeliveryRadioButton);
    }
    public void pressProceedToNextStepButton(){
        click(proceedToNextStepButton);
    }
}
