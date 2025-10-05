package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

private final By accountButton =By.cssSelector("label[for='dpdw-login']");
private final By myAccountButton=By.linkText("My Account");
private final By signInButton=By.cssSelector("a[class='btn _prim -fw _md']");
private final By logOutButton=By.cssSelector("button[type='submit']");
private final By savedItemsButton=By.linkText("Saved Items");
private final By popUp=By.xpath("//button[@aria-label='newsletter_popup_close-cta']");
private final By searchBar=By.id("fi-q");
private final By searchButton=By.cssSelector(".btn._prim._md.-mls.-fsh0");
private final By signingAssertionText=By.cssSelector("label[for='dpdw-login']");
private final By cartButton=By.id("ci");
private final By arabicLanguageButton=By.cssSelector("a[class='-vrl -fs0'] span[class='-dif -i-ctr -fs12']");
private final By changingLanguageAssertionText=By.xpath("//label[text()='تسجيل الدخول']");
private final By newsLetterEmailField=By.id("fi-nl-ft-email");
private final By newsLetterMale=By.cssSelector("button[value='male']");
private final By newsLetterFemale=By.cssSelector("button[value='female']");
private final By newsLetterMessage=By.cssSelector(".cnt");
private final By existSubscriptionMessage=By.xpath("//div[@class='fi-er']");
private final By cookiesCancelButton=By.cssSelector(".cls");

public void closePopUp(){
    click(popUp);
}
public AuthenticationPage goToSignInPage(){
    click(accountButton);
    click(signInButton);
    return new AuthenticationPage();
}
public SearchResultsPage search(String searchWord){
    sendKeys(searchBar,searchWord);
    click(searchButton);
    return  new SearchResultsPage();
}
public String getAssertionText(){
    return getText(signingAssertionText);
}
public MyAccountPage goToMyAccountPage()   {
    click(accountButton);
    click(myAccountButton);
    return new MyAccountPage();
}
public SavedItemsPage goToSavedItemsPage()   {
        click(accountButton);
        click(savedItemsButton);
        return new SavedItemsPage();
    }
public void Logout(){
    click(accountButton);
    click(logOutButton);
}
public String logOutAssertionText(){
    return getText(accountButton);
}
public CartPage gotoCart(){
    click(cartButton);
    return new CartPage();
}
public void changeToArabic(){
    click(arabicLanguageButton);
}
public String arabicAssertionText(){
    return getText(changingLanguageAssertionText);
}
public void enterEmailForNewsLetter(String email){
    sendKeys(newsLetterEmailField,email);
}
public void chooseGender(String gender){
    if (gender=="male"){
        click(newsLetterMale);
    } else if (gender=="female") {
        click(newsLetterFemale);
    }
}
public String getNewsLetterEmailMessage(){
    return getText(newsLetterMessage);
}
public String getAlreadySubscribedMessage(){
    return getText(existSubscriptionMessage);
}
public void cancelCookiesMessage(){
    elementVisibilityExplicitWait(cookiesCancelButton,8);
    click(cookiesCancelButton);
}

}

