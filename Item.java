package edu.psu.abington.ist.ist242;
public class Item {

    private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;
    private PizzaSize pizzaSize;
    protected int numTimesOrdered = 0;

    public Item(int itemID, String name, double price, boolean isAvailable) {
        this.itemId = itemID;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Item(int itemId, String name, PizzaSize pizzaSize, double price, boolean isAvailable) {
        this(itemId, name, price, isAvailable);
        this.pizzaSize = pizzaSize;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumTimesOrdered() {
        return numTimesOrdered;
    }

    @Override
    public String toString() {
        return "Item Name: " + name + " -- Price: $" + price + " -- Sold Out: " + isAvailable;
    }
}
