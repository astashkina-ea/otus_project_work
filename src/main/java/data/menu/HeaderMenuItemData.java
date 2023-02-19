package data.menu;

public enum HeaderMenuItemData {

    LEARNING("learning");

    private String name;

    HeaderMenuItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}