package component.popup;

import component.AbsBaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePopup extends AbsBaseComponent{

    public CookiePopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[type=button]")
    private WebElement buttonCookie;

    public CookiePopup clickOnButtonCookie() {
        webDriverWait.waitForVisibleElement(buttonCookie);
        buttonCookie.click();
        return this;
    }
}