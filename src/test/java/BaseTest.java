import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
        open(BASE_URL);
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
