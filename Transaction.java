package edu.psu.abington.ist.ist242;
public class Transaction {

    private int transactionId;
    private final Order ORDER;
    private PaymentType paymentType;
    private static int receiptNum = 0;

    public Transaction(int transactionId, Order order, PaymentType paymentType) {
        this.transactionId = transactionId;
        this.ORDER = order;
        this.paymentType = paymentType;
        receiptNum++;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Order getORDER() {
        return ORDER;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public static int getReceiptNum() {
        return receiptNum;
    }

    public void printReceipt() {
        String lines = "---------------------------------------------";

        System.out.printf("%s%n%20s %d%n%s%n",lines,"Receipt",getReceiptNum(), lines);

        for (Item i : ORDER.getORDERED_ITEMS()) {
            System.out.printf("(%d) %s %10s%10.2f%n",i.getNumTimesOrdered(), i.getName(),
                    "$",i.getPrice());
        }
        System.out.println(lines);
        System.out.println("\t\t\t\t\t\t\t\t\t" + "$" + ORDER.getSubTotal());
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nOrder Items: " + ORDER.toString() +
                "\nOrder SubTotal: " + ORDER.getSubTotal() +
                "\nPayment Type: " + paymentType;
    }

}