package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage {

    private By signInButton = By.cssSelector(".header3__button-sign-in");

    public MainPage(WebDriver driver) {
        super(driver, "/");
    }
}