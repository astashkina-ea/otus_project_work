import component.CourseCatalog;
import component.CourseFilterComponent;
import component.HeaderMenuComponent;
import component.popup.HeaderPopup;
import data.CategoryData;
import data.CoursesTestingData;
import data.EventsSortData;
import data.courses.CoursesDurationData;
import data.courses.CoursesFormatData;
import data.courses.CoursesSubTitleData;
import data.courses.CoursesTitleData;
import data.menu.HeaderMenuItemData;
import data.menu.SubMenuCategoryCourseItemData;
import exception.BrowserNorSupportedException;
import factories.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageObject.pages.CoursePage;
import component.EventsCatalog;
import pageObject.pages.EventsPage;
import pageObject.pages.MainPage;

public class MainTest {

    private WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    @BeforeAll
    public static void setUpDriver() throws BrowserNorSupportedException {
        new WebDriverFactory().setUp();
    }

    @BeforeEach
    public void init() throws BrowserNorSupportedException {
        driver = new WebDriverFactory().createDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void checkCountCoursesTest() {

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING);

        new CourseFilterComponent(driver)
                .checkСourseFilterComponent(CategoryData.TESTING, true);

        new CourseCatalog(driver)
                .checkVisibleCourses()
                .checkCountCourses(12);
    }

    @Test
    public void checkCourseInfoTest() {

        String titleCourse = "Java QA Engineer. Professional";
        String subTitleCourse = "Автоматизация тестирования на Java продвинутого уровня";
        String durationCourse = "4 месяца";
        String formatCourse = "Online";

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING);

        new CourseCatalog(driver)
                .clickCourse(CoursesTestingData.JAVA_QA_PRO.getName());

        new CoursePage(driver)
                .checkTitleCourse(titleCourse, CoursesTitleData.JAVA_QA_PRO)
                .checkSubTitleCourse(subTitleCourse, CoursesSubTitleData.JAVA_QA_PRO)
                .checkDurationCourse(durationCourse, CoursesDurationData.JAVA_QA_PRO)
                .checkFormatCourse(formatCourse, CoursesFormatData.JAVA_QA_PRO);
    }

    @Test
    public void checkEventsDateTest() {

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR);

        new EventsCatalog(driver)
                .checkVisibleEvents()
                .checkEventsDate();
    }

    @Test
    public void checkSortEventsTest() {

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR);

        new EventsCatalog(driver)
                .sortEvents(EventsSortData.OPENWEBINAR);
        new EventsPage(driver)
                .checkSortByEvent(EventsSortData.OPENWEBINAR);
    }
}