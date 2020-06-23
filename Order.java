package edu.psu.abington.ist.ist242;
import java.util.ArrayList;

public class Order { // IMMUTABLE CLASS!

    private final int ORDER_ID;
    private final Customer CUSTOMER;
    private final ArrayList <Item> ORDERED_ITEMS;

    public Order(int orderId, Customer customer, ArrayList <Item> orderedItems) {
        this.ORDER_ID = orderId;
        this.CUSTOMER= customer;
        this.ORDERED_ITEMS = orderedItems;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public Customer getCUSTOMER() {
        return CUSTOMER;
    }

    public ArrayList <Item> getORDERED_ITEMS() {
        return ORDERED_ITEMS;
    }

    public double getSubTotal() {
        double sum = 0;
        for (Item i : ORDERED_ITEMS) {
            sum += i.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order ID: " + ORDER_ID +
                "\nCustomer: " + CUSTOMER +
                "\nOrder Quantity: " +
                "\nMenu Items: " + ORDERED_ITEMS;
    }

}



