import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.bidi.log.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.Arrays.asList;

public class SidePanelTest extends BaseTest{


    @Test
    public void allLinksAreDisplayed(){
        loginPage.successLogin("Admin", "admin123");
        //implementation
    }

    @Test @Category(Smoke.class)
    public void searchExactLink(){
        String query = "Dashboard";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.getAvailableLinksNames().get(0).shouldBe(visible);
        sidePanel.getAvailableLinksNames().get(0).shouldHave(exactText(query));
        sidePanel.getAvailableLinksNames().shouldHave(size(1));
    }


    //part text
    @Test
    public void searchByPartText(){
        String query = "D";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.getAvailableLinksNames().shouldHave(size(3));
        sidePanel.checkTextNamesOfAvailableLinks(query);
    }
    //invalid input value for search
    @Test
    public void searchOfInvalidNameLink(){
        String query = "3ty63w7637832";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.getAvailableLinksNames().shouldHave(size(0));
    }



    //input and delete after
    @Test
    public void searchInputAndDelete(){
        String query = "123";
        loginPage.successLogin("Admin", "admin123");
        sidePanel.inputSearchRequest(query);
        sidePanel.clearRequest();
        sidePanel.getAvailableLinksNames().shouldHave(size(12));
    }


    //*check expand side panel
    @Test
    public void checkExpandCollapseSidePanel(){
        List<String> expectedTextLinks = new ArrayList<>(asList("Admin","PIM",  "Leave","Time",
                "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance",
                "Claim", "Buzz"));
        loginPage.successLogin("Admin", "admin123");
        sidePanel.getSidePanel().shouldNotHave(cssClass("toggled"));
        sidePanel.getAvailableLinksNames().filter(visible).shouldHave(size(12));
        sidePanel.checkAllCorrectCollectionTexts(expectedTextLinks);
        sidePanel.clickOnArrow();
        sidePanel.getSidePanel().shouldHave(cssClass("toggled"));
        sidePanel.getAvailableLinksNames().filter(visible).shouldHave(size(12));
    }

}
