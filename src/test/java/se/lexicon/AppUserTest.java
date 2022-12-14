package se.lexicon;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

public class AppUserTest {

    @Test
    public void getSummaryTest()
    {
        AppUser user = new AppUser("ishu","123456", AppRole.ROLE_APP_USER);
        String expectedResult = "AppUser{username='ishu', role=ROLE_APP_USER}";
        String actualResult = user.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
