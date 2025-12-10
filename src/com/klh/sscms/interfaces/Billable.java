package com.klh.sscms.interfaces;


/**
 * Interface for billing operations (fee calculation, invoices).
 */
public interface Billable {

    /**
     * Returns the billing amount.
     * @return total amount as double
     */
    double calculateAmount();

    /**
     * Returns invoice details as a formatted string.
     */
    String generateInvoice();
}
