
package com.klh.sscms.services;

import com.klh.sscms.interfaces.Billable;

public class BillingService implements Billable {

    private double baseFee;
    private double gst;

    public BillingService(double baseFee, double gst) {
        this.baseFee = baseFee;
        this.gst = gst;
    }

    @Override
    public double calculateAmount() {
        return baseFee + (baseFee * gst / 100.0);
    }

    @Override
    public String generateInvoice() {
        return "Base Fee: " + baseFee +
               "\nGST: " + gst + "%" +
               "\nTotal Amount: " + calculateAmount();
    }
}
