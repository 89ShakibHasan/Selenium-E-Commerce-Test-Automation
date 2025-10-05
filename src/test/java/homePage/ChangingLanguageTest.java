package homePage;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.Listeners.class)
public class ChangingLanguageTest extends BaseTest {
    @Test
    public void changeLanguageToArabic(){
        homePage.closePopUp();
        homePage.changeToArabic();
        Assert.assertEquals(homePage.arabicAssertionText(),"تسجيل الدخول");
    }

}
