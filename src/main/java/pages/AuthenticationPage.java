package pages;

import org.openqa.selenium.By;

public class AuthenticationPage extends BasePage {
    private final By emailField=By.name("email");
    private final By continueButton=By.xpath("//button[@type='submit']");
    private final By invalidEmailMessage=By.id("api-error");
    private final By emptyEmailMessage=By.id("empty-email-error-message");

    public void enterEmail(String email){
        sendKeys(emailField,email);
    }
    public SignUpPage continueSigningUp(){
    click(continueButton);
    return new SignUpPage();
    }
    public SignInPage continueSigningIn(){
        click(continueButton);
        return new SignInPage();
    }
    public String getInvalidEmailText(){
        return getText(invalidEmailMessage);
    }
    public String getEmptyEmailText(){
        return getText(emptyEmailMessage);
    }
}
