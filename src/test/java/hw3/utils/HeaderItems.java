package hw3.utils;

public enum HeaderItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String itemName;

    HeaderItems(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

}
