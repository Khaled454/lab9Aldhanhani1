package edu.psu.abington.ist.ist242;
import java.util.Random;

public class Customer {

    private final int customerId;
    private String customerName;
    private String customerPhoneNumber;
    private final Random RANDOM;

    public Customer(String customerName, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.RANDOM= new Random();
        this.customerId = generateCustomerId();
    }

    public Customer(String customerName) {
        this(customerName,"No phone given");
    }

    public Customer() {
        this("Default Name","Default Phone #");
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    private int generateCustomerId() {
        return RANDOM.nextInt(100);
    }

    @Override
    public String toString() {
        return "Customer Id:" + customerId + "\nCustomer Name:" + customerName +
                "\nCustomer Phone:" + customerPhoneNumber;
    }
}


