package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SignUpPage extends BasePage {

    private final By passwordField=By.name("password");
    private final By confirmPasswordField=By.xpath("//input[contains(@class,'confirm-password')]");
    private final By passwordStrengthText=By.id("password-strength-text");
    private final By continueButton2=By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded']");
    private final By unMatchedPasswordsMessage=By.id("confirm-password-label");

    public void enterPassword(String password){
        sendKeys(passwordField,password);
    }
    public void confirmPassword(String password){
        sendKeys(confirmPasswordField,password);

    }
    public PersonalDetailsPage continueSigning2(){
        elementClickableExplicitWait(continueButton2,10);
        Actions a =new Actions(driver);
        a.doubleClick(find(continueButton2)).perform();
        //click(continueButton2);
        return new PersonalDetailsPage();
    }
    public String getWeakPasswordText(){
        return getText(passwordStrengthText);
    }
    public String getUnMatchedPasswordsText(){
        return getText(unMatchedPasswordsMessage);
    }
}
