package fail;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToFail extends BaseTest {
    @Test
    public void changeLanguageToArabicFailing(){
        homePage.closePopUp();
        homePage.changeToArabic();
        Assert.assertEquals(homePage.arabicAssertionText(),"hi");
    }
}
