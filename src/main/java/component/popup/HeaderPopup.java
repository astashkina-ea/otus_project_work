package component.popup;

import component.AbsBaseComponent;
import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPopup extends AbsBaseComponent implements IPopup {

    public HeaderPopup(WebDriver driver) {
        super(driver);
    }

    private String headerSubmenuPopupSelector = "[data-name='%s'].js-header3-popup";
    private String subMenuItemLocator = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(text(), '%s')])[1]";

    @Override
    public HeaderPopup popupShouldNotBeVisible(HeaderMenuItemData headerMenuItemData) {

        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemData.getName());
        webDriverWait.waitForAttributeContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    @Override
    public HeaderPopup popupShouldBeVisible(HeaderMenuItemData headerMenuItemData) {

        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemData.getName());
        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    public HeaderPopup clickSubMenuItemCoursesName(ISubMenu subMenuItemData) {

        String locator = String.format(subMenuItemLocator, subMenuItemData.getName());
        $(By.xpath(locator)).click();
        return this;
    }
}