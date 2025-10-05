package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{

    private final By passwordField=By.cssSelector("input[name='password']");
    private final By wrongLoggingInPasswordText =By.cssSelector("div[role='alert']");
    private final By logInButton=By.id("loginButton");

    public void enterPassword(String password){
        sendKeys(passwordField,password);
    }
    public void completeSigningIn(){
        click(logInButton);
    }
    public String getWrongPasswordText(){
        elementClickableExplicitWait(logInButton,10);
        return getText(wrongLoggingInPasswordText);
    }

}
