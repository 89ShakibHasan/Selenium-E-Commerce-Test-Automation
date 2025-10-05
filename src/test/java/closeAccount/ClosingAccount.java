package closeAccount;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClosingAccount extends BaseTest {
    @Test
    public void closingAccount() throws InterruptedException {
        login();
        var myAccountPage=homePage.goToMyAccountPage();
        myAccountPage.closeCookiesMessage();
        myAccountPage.goToCloseAccount();
        myAccountPage.chooseAReasonForClosingAccount();
        myAccountPage.scroll();
        Thread.sleep(2000);
        myAccountPage.selectClosingCheckBox();
        myAccountPage.pressCloseMyAccountButton();
        myAccountPage.goToCloseAccount();
        Assert.assertEquals(myAccountPage.getClosingAccountConfirmationMessage(),"Request is being processed");
    }
}
