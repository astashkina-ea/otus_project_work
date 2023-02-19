package data.menu;

public enum SubMenuCategoryCourseItemData implements ISubMenu{

    TESTING("Тестирование"),
    LESSON_CALENDAR("Календарь мероприятий");

    private String name;

    SubMenuCategoryCourseItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}