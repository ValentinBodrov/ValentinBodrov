package hw4.utils;

public enum ServiceLeftSideItems {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    SEARCH("Search"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String itemName;

    ServiceLeftSideItems(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

}
