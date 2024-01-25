import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.bidi.log.Log;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class LoginTest extends BaseTest{


    @Test
    public void successLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        dashboardPage.getHeader().shouldBe(visible).shouldHave(text("Dashboard"));
    }

    //invalid password
    @Test
    public void invalidPassword(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("dfghasgdhs");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessageText().shouldBe(visible);
        loginPage.getErrorMessageText().shouldHave(text("Invalid credentials"));
    }
    //non existing user
    @Test
    public void invalidUsername(){
        loginPage.enterUsername("sdfdsf");
        loginPage.enterPassword("dfghasgdhs");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessageText().shouldBe(visible);
        loginPage.getErrorMessageText().shouldHave(text("Invalid credentials"));
    }

    @Test
    public void elementsAreDisplayed(){
        //check that logo is displayed
        loginPage.getLogo().shouldBe(visible);
        loginPage.logoImageIsCorrect();
        //creds section is displayed
        loginPage.getCredSection().shouldBe(visible);
        loginPage.getLinkedInIcon().shouldBe(visible);
        loginPage.getFacebookIcon().shouldBe(visible);
        loginPage.getTwitterIcon().shouldBe(visible);
        loginPage.getYouTubeIcon().shouldBe(visible);
    }

    @Test
    public void linkedInLinkIsCorrect(){
        loginPage.clickOnLinkedInIcon();
        //sleep(20000);
        switchTo().window(1);
        linkedInPage.getPopupText().shouldHave(text("LinkedIn"));
        //CHECK facebook link
        //CHECK twitter link
        //CHECK youtube link
        //switchTo().window(0);
    }
    @Test
    public void facebookLinkIsCorrect(){
        //
    }
    @Test
    public void twitterLinkIsCorrect(){
        //
    }
    @Test
    public void youTubeLinkIsCorrect(){
        //
    }

    @Test
    public void resetPasswordPage(){
        //Username input field
        //Cancel button
        //Reset Password button
    }
    @Test
    public void resentPasswordLinkSending(){
        //
    }
    @Test
    public void resetPasswordWithoutUsername(){
        //
    }



}
