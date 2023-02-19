package component.popup;

import data.menu.HeaderMenuItemData;

public interface IPopup {
    public HeaderPopup popupShouldNotBeVisible(HeaderMenuItemData headerMenuItemData);
    public HeaderPopup popupShouldBeVisible(HeaderMenuItemData headerMenuItemData);
}