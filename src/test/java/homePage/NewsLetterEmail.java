package homePage;

import base.BaseTest;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewsLetterEmail extends BaseTest {

    @Test(priority = 0,dataProvider = "newsletter")
    public void testEnteringEmailForNews(String email, String gender) {
        homePage.closePopUp();
        homePage.enterEmailForNewsLetter(email);
        try {
            homePage.chooseGender(gender);
        } catch (ElementClickInterceptedException e) {
            homePage.cancelCookiesMessage();
        }
        homePage.chooseGender(gender);
        Assert.assertEquals(homePage.getNewsLetterEmailMessage(),"Thank you for subscribing! Your request will be processed.");
    }


    @Test(priority = 1,dataProvider = "newsletter")
    public void testEnteringAlreadySentEmailForNews(String email, String gender)  {
        homePage.closePopUp();
        homePage.enterEmailForNewsLetter(email);
        try {
        homePage.chooseGender(gender);
        } catch (ElementClickInterceptedException e) {
            homePage.cancelCookiesMessage();
        }
        homePage.chooseGender(gender);
        Assert.assertEquals(homePage.getAlreadySubscribedMessage(),"A subscription already exists for this e-mail.");
    }

}
