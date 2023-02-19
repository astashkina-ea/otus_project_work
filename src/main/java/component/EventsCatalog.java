package component;

import data.DateData;
import data.EventsSortData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.AbsBasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventsCatalog extends AbsBasePage {

    public EventsCatalog(WebDriver driver) {
        super(driver, "/");
    }

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> eventsListLocator;

    @FindBy(css = ".dod_new-event__time")
    private List<WebElement> eventsDateListLocator;

    @FindBy(css = ".dod_new-events-dropdown__input")
    private WebElement sortEventsCloseLocator;

    private String sortEventsOpenLocator = "div[class*='dod_new-events-dropdown_opened'] a[title='%s']";

    public EventsCatalog checkVisibleEvents() {

        for (WebElement element : eventsListLocator) {
            Assertions.assertTrue(element.isDisplayed());
        }
        return this;
    }

    public EventsCatalog checkEventsDate() {

        List<String> eventsDateListString = new ArrayList<>();
        List<LocalDate> eventsDateListDate = new ArrayList<>();
        for (WebElement element : eventsDateListLocator) {
            eventsDateListString.add(element.getText());
        }
        for (String string : eventsDateListString) {
            String day = string.split(" ")[0];
            String month = string.split(" ")[1];
            month = month.replaceAll("[а-я]+", DateData.getDateData(month).getId());
            String date = day + " " + month + " " + "2023";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd MM yyyy", Locale.ROOT));
            if (string.equals("Сейчас в эфире")) {
                eventsDateListDate.add(LocalDate.now());
            } else {
                eventsDateListDate.add(localDate);
            }
        }
        for (LocalDate localDate : eventsDateListDate) {
            Assertions.assertTrue(localDate
                    .isAfter(localDate.now()) || localDate.isEqual(localDate.now()));
        }
        return this;
    }

    public EventsCatalog sortEvents(EventsSortData eventsSortData) {

        sortEventsCloseLocator.click();
        String locator = String.format(sortEventsOpenLocator, eventsSortData.getNameFilter());
        $(By.cssSelector(locator)).click();
        return this;
    }
}