import org.junit.Test;
import org.openqa.selenium.bidi.log.Log;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class SidePanelTest extends BaseTest{


    @Test
    public void allLinksAreDisplayed(){
        loginPage.successLogin("Admin", "admin123");
        //implementation
    }

}
