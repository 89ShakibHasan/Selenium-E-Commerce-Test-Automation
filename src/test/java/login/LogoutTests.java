package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTests extends BaseTest {
    @Test
    public void testSuccessfulLogOut(){
        login();
        homePage.Logout();
        Assert.assertEquals(homePage.logOutAssertionText(),"Account");

    }
}
