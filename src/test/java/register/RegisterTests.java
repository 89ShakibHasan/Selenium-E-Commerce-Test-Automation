package register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class RegisterTests extends BaseTest {
    private final String email="06dd6efd668f@drmail.in";
    private final String password="gETZKvbhZ9m#Tpa";

    @Test(priority = 0)
    public void testInvalidEmail(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("sfdgas@cds");
        authenticationPage.continueSigningIn();
        Assert.assertEquals(authenticationPage.getInvalidEmailText(),"This email is not valid. Insert a valid email to continue.");
    }
    @Test(priority = 1)
    public void testEmptyEmail(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("  ");
        authenticationPage.continueSigningIn();
        Assert.assertEquals(authenticationPage.getEmptyEmailText(),"Type your email to login or create an account.");
    }
    @Test(priority = 2)
    public void testShortPasswordRegistration(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword("123456");
        signUpPage.confirmPassword("123456");
        Assert.assertEquals(signUpPage.getWeakPasswordText(),"Weak");
    }
    @Test(priority = 3)
    public void testUnMatchedPasswords(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword("gETZKvbhZ9m#Tpa");
        signUpPage.confirmPassword("gETZKvbhZ9m#Tp");
        signUpPage.continueSigning2();
        Assert.assertEquals(signUpPage.getUnMatchedPasswordsText(),"Both passwords must match");

    }
    @Test(priority = 4)
    public void testShortFNameRegistration(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword(password);
        signUpPage.confirmPassword(password);
        var personalDetailsPage=signUpPage.continueSigning2();
        String firstName="E";
        personalDetailsPage.enterFirstName(firstName);
        //personalDetailsPage.enterMiddleName("Khaled");
        personalDetailsPage.enterLastName("Eslam");
        personalDetailsPage.enterPhoneNumber("01013255468");
        Assert.assertEquals(personalDetailsPage.getShortFNameText(),"Name must have a minimum of 2 characters and maximum of 60.");
    }
    @Test(priority = 5,dataProvider = "getData")
    public void testingInvalidNames(String FName, String LName){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword(password);
        signUpPage.confirmPassword(password);
        var personalDetailsPage=signUpPage.continueSigning2();
        personalDetailsPage.enterFirstName(FName);
        personalDetailsPage.enterLastName(LName);
        personalDetailsPage.enterPhoneNumber("01013255468");
        Assert.assertEquals(personalDetailsPage.getInvalidFNameText(),"Name must have a minimum of 2 characters and maximum of 60.");
        Assert.assertEquals(personalDetailsPage.getInvalidLNameText(),"Name must have a minimum of 2 characters and maximum of 60.");
    }
    @Test(priority = 6)
    public void testInvalidPhoneRegistration(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword(password);
        signUpPage.confirmPassword(password);
        var personalDetailsPage=signUpPage.continueSigning2();
        personalDetailsPage.enterFirstName("Eslam");
       // personalDetailsPage.enterMiddleName("Khaled");
        personalDetailsPage.enterLastName("Eslam");
        personalDetailsPage.enterPhoneNumber("3534");
        personalDetailsPage.pressContinue();
        personalDetailsPage.chooseGender("male");
        personalDetailsPage.chooseBirthDate("2171997");
        personalDetailsPage.selectCheckBox();
        personalDetailsPage.finishSigning();
        Assert.assertEquals(personalDetailsPage.getInvalidPhoneText(),"Type a valid Phone number to continue");
    }
    @Test(priority = 7)
    public void successfulRegistration() throws InterruptedException {
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail(email);
        var signUpPage=authenticationPage.continueSigningUp();
        signUpPage.enterPassword(password);
        signUpPage.confirmPassword(password);
        var personalDetailsPage=signUpPage.continueSigning2();
        String firstName="Eslam";
        personalDetailsPage.enterFirstName(firstName);
        //personalDetailsPage.enterMiddleName("Khaled");
        personalDetailsPage.enterLastName("Eslam");
        personalDetailsPage.enterPhoneNumber("01013255468");
        personalDetailsPage.pressContinue();
        personalDetailsPage.chooseGender("male");
        personalDetailsPage.chooseBirthDate("2171997");
        personalDetailsPage.selectCheckBox();
        personalDetailsPage.finishSigning();
       // personalDetailsPage.enterPinNumber("123456123456");
        Thread.sleep(8000);
        Assert.assertEquals(homePage.getAssertionText(),"Hi, "+firstName);

    }
}
