import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
        Configuration.timeout = 10000;
        Configuration.fastSetValue = true;
        Configuration.clickViaJs = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "300x300";
        Configuration.headless = true;
        open(BASE_URL);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LinkedInPage linkedInPage = new LinkedInPage();

    SidePanel sidePanel = new SidePanel();

}
