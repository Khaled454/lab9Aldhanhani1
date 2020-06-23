package edu.psu.abington.ist.ist242;
public enum PizzaSize {

    SMALL("SM", "Small"),
    MEDIUM("MD","Medium"),
    LARGE("LG", "Large"),
    EXTRALARGE("XL","Extra Large");

    private String sizeSymbol;
    private String sizeString;

    PizzaSize(String sizeSymbol, String sizeString) {
        this.sizeSymbol = sizeSymbol;
        this.sizeString = sizeString;
    }

    public String getSizeSymbol() {
        return sizeSymbol;
    }

    @Override
    public String toString() {
        return sizeString;
    }
}
