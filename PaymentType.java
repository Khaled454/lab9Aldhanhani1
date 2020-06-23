package edu.psu.abington.ist.ist242;
public enum PaymentType {

    CASH("CSH","Cash"),
    CREDIT("CDT","Credit");

    private final String paymentSymbol;
    private final String paymentTypeString;

    PaymentType(String paymentSymbol, String paymentTypeString) {
        this.paymentSymbol = paymentSymbol;
        this.paymentTypeString = paymentTypeString;
    }

    public String getPaymentSymbol() {
        return paymentSymbol;
    }

    @Override
    public String toString() {
        return paymentTypeString;
    }
}
