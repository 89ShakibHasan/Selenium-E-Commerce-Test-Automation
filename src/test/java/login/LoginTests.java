package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AuthenticationPage;


public class LoginTests extends BaseTest {

    @Test(priority = 0)
    public void testWrongPasswordLogin()  {
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("c5fee9c3adc8@drmail.in");
        var signInPage= authenticationPage.continueSigningIn();
        signInPage.enterPassword("2125");
        signInPage.completeSigningIn();
        Assert.assertTrue(signInPage.getWrongPasswordText().contains("Wrong password. Try again or click 'Forgot Password?' to reset it"));
    }

    @Test(priority = 1)
    public void testSuccessfulLogin(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("c5fee9c3adc8@drmail.in");
        var signInPage= authenticationPage.continueSigningIn();
        signInPage.enterPassword("gETZKvbhZ9m#Tpa");
        signInPage.completeSigningIn();
        Assert.assertTrue(homePage.getAssertionText().contains("Hi, "));
    }
}

