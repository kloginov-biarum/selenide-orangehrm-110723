import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanel {

    private SelenideElement arrow = $(byClassName("oxd-main-menu-button"));
    private SelenideElement sidePanel = $(byClassName("oxd-sidepanel"));

    public SelenideElement getSidePanel() {
        return sidePanel;
    }

    private ElementsCollection links = $$(byClassName("oxd-main-menu-item-wrapper"));

    private ElementsCollection availableLinksNames = $$(byClassName("oxd-main-menu-item"));

    private SelenideElement searchInputField = $(byAttribute("placeholder", "Search"));

    public void checkLinksAmount(){
        links.shouldHave(size(12));
    }

    public void checkAvailableLinksAmount(int expectedAmount){
        availableLinksNames.shouldHave(size(expectedAmount));
    }
    public void checkTextNamesOfAvailableLinks(String partText){
        for (SelenideElement element:availableLinksNames) {
            //element should have partText
            element.shouldHave(Condition.partialText(partText));
        }
    }

    public ElementsCollection getAvailableLinksNames() {
        return availableLinksNames;
    }
    public void checkAllCorrectCollectionTexts(List<String> expected){
        availableLinksNames.shouldHave(textsInAnyOrder(expected));
    }

    public void inputSearchRequest(String query){
        searchInputField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        searchInputField.setValue(query);
    }
     public void clearRequest(){
        searchInputField.sendKeys(Keys.BACK_SPACE);
         searchInputField.sendKeys(Keys.BACK_SPACE);
         searchInputField.sendKeys(Keys.BACK_SPACE);
     }

    public void clickOnArrow(){
        arrow.click();
    }

}
